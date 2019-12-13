package com.mixo.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.mixo.NavigationHost
import com.mixo.ProductGridFragment
import com.mixo.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    companion object {
        val TAG = "LoginActivity"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_login, container, false)

        view.login_button.setOnClickListener {
            performLogin()
        }

        view.back_to_register_textview.setOnClickListener {
            Log.d(TAG, "Try to show register activity")

            // Launch the register activity
            val intent = Intent(activity, RegisterActivity::class.java)
            startActivity(intent)
            activity!!.overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left)
        }

        return view
    }

    private fun performLogin() {
        val email = email_edit_text_login.text.toString()
        val password = password_edit_text_login.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(activity, "Please fill out email/pw.", Toast.LENGTH_SHORT).show()
            return
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                Log.d("Login", "Successfully logged in: ${it.result?.user?.uid}")

                (activity as NavigationHost).navigateTo(ProductGridFragment(), false) // Navigate to the next Fragment

                activity!!.overridePendingTransition(R.animator.enter, R.animator.exit)
            }
            .addOnFailureListener {
                Toast.makeText(activity, "Failed to log in: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }


}
