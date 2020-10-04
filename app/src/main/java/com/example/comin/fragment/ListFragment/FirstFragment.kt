package com.example.comin.fragment.ListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comin.R
import kotlinx.android.synthetic.main.fragment_first.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array: ArrayList<ContentListModel> = arrayListOf(
            ContentListModel("list1","lang1",1,"cherry"),
            ContentListModel("list2","lang2",1,"cherry"),
            ContentListModel("list3","lang3",1,"cherry"),
            ContentListModel("list4","lang4",1,"cherry"),
            ContentListModel("list5","lang5",1,"cherry"),
            ContentListModel("list6","lang6",1,"cherry"),
            ContentListModel("list7","lang7",1,"cherry"),
            ContentListModel("list8","lang8",1,"cherry"),
            ContentListModel("list9","lang9",1,"cherry"),
        )

        val firstFragAdapter = FirstFragAdapter(inflater.context,list_array)

        view.recycler_view_first_fragment.apply {
            adapter = firstFragAdapter
            layoutManager = LinearLayoutManager(inflater.context)
        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}