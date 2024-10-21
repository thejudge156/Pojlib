package pojlib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

import pojlib.android.R;
import pojlib.android.databinding.FragmentFirstBinding;
import pojlib.util.JREUtils;
import pojlib.util.json.MinecraftInstances;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(v -> {
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);

                    MinecraftInstances.Instance instance = new MinecraftInstances.Instance();
                    instance.gameDir = this.getActivity().getFilesDir().getAbsolutePath();
                    try {
                        JREUtils.launchJavaVM(this.getActivity(), new ArrayList<>(), instance);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}