package cicata.ipn.app_productos

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cicata.ipn.app_productos.databinding.FragmentAltaBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AltaFragment: Fragment() {

    private var _binding: FragmentAltaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAltaBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.buttonVolver?.setOnClickListener {
            findNavController().navigate(R.id.action_altaFragment_to_inicioFragment)
        }


        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val fStore = FirebaseFirestore.getInstance()
        val stringNombre = _binding?.editProducto?.text
        val stringTalla = _binding?.EditTalla?.text
        val stringColor = _binding?.editColor?.text
        val stringPrecio = _binding?.editPrecio?.text


        _binding?.buttonDarAlta?.setOnClickListener {

        val userID = firebaseAuth.currentUser?.uid
        val atributes = HashMap<String,Any>()

        atributes["Nombre del producto"] = "$stringNombre"
        atributes["Tall del Producto"] = "$stringTalla"
        atributes["Color del Prodcuto"] = "$stringColor"
        atributes["Precio del Producto"] = "$stringPrecio"

            fStore.collection("Productos").add(atributes).addOnSuccessListener {
                Log.d("LOG", "Se han agregado los productos a: $userID")}

            findNavController().navigate(R.id.action_altaFragment_to_inicioFragment)

        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }

}