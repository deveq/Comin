package com.example.comin.fragment.MarketInfo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_review.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReviewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var auth : FirebaseAuth
    private var database = FirebaseFirestore.getInstance()

    private val text_array = ArrayList<String>()
    private val nickname_array = ArrayList<String>()
    private val rating_array = ArrayList<String>()


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
        val view = inflater.inflate(R.layout.fragment_review, container, false)

        auth = Firebase.auth

        view.write_btn.setOnClickListener {

            if (auth.currentUser == null) {
                Toast.makeText(requireContext(),"회원가입 혹은 로그인해주세요",Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(requireContext(),WriteActivity::class.java)
                startActivity(intent)

            }

        }

        //리사이클러뷰에 adapter 연결
        val adapter = ReviewAdapter(nickname_array,text_array,rating_array)
        view.recycler_view_review.adapter= adapter
        view.recycler_view_review.layoutManager = LinearLayoutManager(requireContext())

        //파이어베이스에서 데이터를 받아옴
        database.collection("reviews")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    rating_array.add(document["rating"] as String)
                    nickname_array.add(document["writer"] as String)
                    text_array.add(document["text"] as String)

                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->

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
         * @return A new instance of fragment ReviewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReviewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}