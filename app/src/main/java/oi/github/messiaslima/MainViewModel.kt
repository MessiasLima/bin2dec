package oi.github.messiaslima

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var decimalNumber = ObservableInt()
    var binaryNumber: String? = null
        set(value) {
            decimalNumber.set(convertBinaryToDecimal(value))
            field = value
        }

    fun convertBinaryToDecimal(binary: String?): Int {
        if (binary.isNullOrBlank()) return 0
        return Integer.parseInt(binary, 2);
    }
}