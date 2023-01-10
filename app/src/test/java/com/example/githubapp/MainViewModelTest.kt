package com.example.githubapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asFlow
import com.example.core.domain.model.ModelDataUser
import com.example.core.domain.usecase.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    //untuk live data
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

    //untuk corountine
    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setupDispatcher() {
        Dispatchers.setMain(testDispatcher)
    }
    @After
    fun tearDownDispatcher() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Ketika Mengambil UserData Tidak Bernilai Null Dan Berhasil`() = runTest{
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