package com.example.myapplication
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_FINANCE_DATA = "finance_data"

        fun newInstance(financeModel: FinanceModel): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putParcelable(ARG_FINANCE_DATA, financeModel)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moTxtFullName.text = "Full Name: Milena Oganiani"
        binding.moTxtBirthYear.text = "Birth Year: 2004"

        val data = arguments?.getParcelable<FinanceModel>(ARG_FINANCE_DATA)
        data?.let {
            val resultText = StringBuilder()
                .append("Salary: $${it.salary}\n")
                .append("Rent: $${it.rent}\n")
                .append("Food: $${it.food}\n")
                .append("Total Expenses: $${it.totalExpenses}\n")
                .append("Remaining Balance: $${it.remainingBalance}\n")
                .append("Recommended Savings: $${it.recommendedSavings}")
                .toString()

            binding.moTxtResultDetails.text = resultText

            if (it.isDeficit) {
                binding.moTxtResultDetails.setTextColor(Color.RED)
            } else {
                binding.moTxtResultDetails.setTextColor(Color.GREEN)
            }
        }

        binding.moBtnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}