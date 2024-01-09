package com.agenda.service.impl;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class FirebaseInit {

    @PostConstruct
    public void onStart() {
        log.info("Initializing Firebase App...");
        try {
            this.initializeFirebaseApp();
        } catch (IOException e) {
            log.error("Initializing Firebase App {}", e);
        }
    }

    private void initializeFirebaseApp() throws IOException {

        if (FirebaseApp.getApps() == null || FirebaseApp.getApps().isEmpty()) {
            InputStream serviceAccount = FirebaseInit.class.getResourceAsStream("/firebase-service-credentials.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();

            FirebaseApp.initializeApp(options);
        }

    }

}
