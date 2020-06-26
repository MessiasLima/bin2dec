package oi.github.messiaslima

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun setBinaryNumber_null() {
        viewModel.binaryNumber = null
        assertEquals(0, viewModel.decimalNumber.get())
    }

    @Test
    fun setBinaryNumber_empty() {
        viewModel.binaryNumber = ""
        assertEquals(0, viewModel.decimalNumber.get())
    }

    @Test
    fun setBinaryNumber_blank() {
        viewModel.binaryNumber = "   "
        assertEquals(0, viewModel.decimalNumber.get())
    }

    @Test
    fun setBinaryNumber_invalid() {
        viewModel.binaryNumber = "a"
        assertEquals(0, viewModel.decimalNumber.get())
    }

    @Test
    fun setBinaryNumber() {
        viewModel.binaryNumber = "101"
        assertEquals(5, viewModel.decimalNumber.get())
        viewModel.binaryNumber = "10100"
        assertEquals(20, viewModel.decimalNumber.get())
        viewModel.binaryNumber = "0010101011010100"
        assertEquals(10964, viewModel.decimalNumber.get())
    }
}