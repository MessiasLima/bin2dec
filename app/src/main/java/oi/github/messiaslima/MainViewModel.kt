package oi.github.messiaslima

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var error = ObservableField<String?>()
    var decimalNumber = ObservableInt()
    var binaryNumber: String? = null
        set(value) {
            error.set(null)
            decimalNumber.set(convertBinaryToDecimal(value))
            field = value
        }

    private fun convertBinaryToDecimal(binary: String?): Int {
        if (binary.isNullOrBlank()) return 0
        return try {
            Integer.parseInt(binary, 2);
        } catch (numberFormatException: NumberFormatException) {
            error.set(numberFormatException.localizedMessage)
            0
        }
    }
}