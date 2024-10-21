package pojlib;

import android.content.ClipboardManager;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.lwjgl.glfw.CallbackBridge;

import java.util.ArrayList;
import java.util.List;

import fr.spse.gamepad_remapper.RemapperManager;
import fr.spse.gamepad_remapper.RemapperView;
import pojlib.android.databinding.ActivityMain2Binding;

import pojlib.android.R;
import pojlib.input.gamepad.Gamepad;
import pojlib.util.JREUtils;
import pojlib.util.json.MinecraftInstances;

public class MainActivity extends AppCompatActivity {
    public static volatile ClipboardManager GLOBAL_CLIPBOARD;
    private Gamepad mGamepad = null;

    private RemapperManager mInputManager;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        GLOBAL_CLIPBOARD = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        /*
        mInputManager = new RemapperManager(this, new RemapperView.Builder(null)
                .remapA(true)
                .remapB(true)
                .remapX(true)
                .remapY(true)

                .remapLeftJoystick(true)
                .remapRightJoystick(true)
                .remapStart(true)
                .remapSelect(true)
                .remapLeftShoulder(true)
                .remapRightShoulder(true)
                .remapLeftTrigger(true)
                .remapRightTrigger(true)
                .remapDpad(true));

        CallbackBridge.nativeSetUseInputStackQueue(true);
         */
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}