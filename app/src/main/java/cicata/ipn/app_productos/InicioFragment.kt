package cicata.ipn.app_productos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cicata.ipn.app_productos.databinding.FragmentAltaBinding
import cicata.ipn.app_productos.databinding.InicioFragmentBinding

class InicioFragment: Fragment() {

    private var _binding: InicioFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = InicioFragmentBinding.inflate(inflater,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.btnListaDeProductos?.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_listaFragment)
        }

        _binding?.buttonAlta?.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_altaFragment)
        }
    }


}