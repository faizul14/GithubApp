package com.example.githubapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asFlow
import com.example.githubapp.core.domain.model.ModelDataUser
import com.example.githubapp.core.domain.usecase.UseCase
import com.example.githubapp.core.utils.DataDummyForTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var useCase: UseCase
    private lateinit var viewModel: MainViewModel
    private val dummyData = DataDummyForTest.generateDummyModelDataUser()

    @Before
    fun setUp() {
        viewModel = MainViewModel(useCase)
    }

    @Test
    fun `Ketika Mengambil UserData Tidak Bernilai NUll Dan Berhasil`() {
        val observer = Observer<List<ModelDataUser>> {}
        try {
            val exceptdData = MutableLiveData<Result<LiveData<List<ModelDataUser>>>>()
            exceptdData.value = Result.success(dummyData)
            `when`(useCase.getDataUser()).thenReturn(dummyData.asFlow())

            val actualData = viewModel.getData().observeForever(observer)

            Assert.assertNotNull(actualData)
        } finally {
            viewModel.getData().removeObserver(observer)
        }
    }


}