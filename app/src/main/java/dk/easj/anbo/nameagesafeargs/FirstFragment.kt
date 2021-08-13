package dk.easj.anbo.nameagesafeargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dk.easj.anbo.nameagesafeargs.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
// https://developer.android.com/guide/navigation/navigation-pass-data
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val name = binding.nameEditText.text.trim().toString()
            if (name.isEmpty()) {
                binding.nameEditText.error = "No name"
                return@setOnClickListener
            }
            val ageStr = binding.ageEditText.text.trim().toString()
            if (ageStr.isEmpty()) {
                binding.ageEditText.error = "No age"
                return@setOnClickListener
            }
            val age = ageStr.toInt()

            val person = Person(name, age)

            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            // Update BOTH build.gradle files
            // FirstFragmentDirections is an automatically generated class
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name, age, person)
            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}