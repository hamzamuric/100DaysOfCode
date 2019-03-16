package hundreddaysofcode.senddatatofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_TEXT = "argText"
private const val ARG_NUMBER = "argNumber"

class ExampleFragment : Fragment() {

    var text: String? = ""
    var number: Int? = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_example, container, false)
        val textView: TextView = view.findViewById(R.id.text_view_fragment)

        text = arguments?.getString(ARG_TEXT)
        number = arguments?.getInt(ARG_NUMBER)

        textView.text = "$text $number"

        return view
    }

    companion object {
        fun newInstance(text: String, number: Int): ExampleFragment {
            return ExampleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXT, text)
                    putInt(ARG_NUMBER, number)
                }
            }
        }
    }

}
