package cicata.ipn.app_productos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cicata.ipn.app_productos.databinding.FragmentListaBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ListaFragment: Fragment() {
    private lateinit var _binding: FragmentListaBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListaBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.btnVolverAlta.setOnClickListener {
            findNavController().navigate(R.id.action_altaFragment_to_inicioFragment)
        }

        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val fStore = FirebaseFirestore.getInstance()
        _binding. btnVerLista.setOnClickListener {
            var datos = " "
            fStore.collection("Productos").get()
                .addOnSuccessListener { resultado ->
                    for(documento in resultado) {
                        datos += "${documento.id}: ${documento.data}\n"
                    }
                    _binding.listaTv.text = datos
                }
                .addOnFailureListener { exception ->
                    _binding.listaTv.text = "No se ha podido conectar"
                }
        }
    }

}