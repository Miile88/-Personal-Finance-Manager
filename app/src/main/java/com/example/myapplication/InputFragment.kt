package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!
    private val financeManager = FinanceManager()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moBtnCalculate.setOnClickListener {
            val salaryStr = binding.moEditSalary.text.toString()
            val rentStr = binding.moEditRent.text.toString()
            val foodStr = binding.moEditFood.text.toString()

            if (salaryStr.isEmpty() || rentStr.isEmpty() || foodStr.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val salary = salaryStr.toDouble()
            val rent = rentStr.toDouble()
            val food = foodStr.toDouble()

            val resultModel = financeManager.calculateFinance(salary, rent, food)

            val resultFragment = ResultFragment.newInstance(resultModel)
            
            parentFragmentManager.beginTransaction()
                .replace(R.id.mo_fragment_container, resultFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}