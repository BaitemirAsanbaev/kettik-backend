package com.example.tourism.security;

import java.util.ArrayList;
import java.util.List;

public class AdminMiddleware {
    public static boolean isAdmin(String email) {
        List<String> admin_domains = new ArrayList<>();
        admin_domains.add("admin");
        admin_domains.add("kettik");
        int atIndex = email.indexOf('@');
        if (atIndex == -1) {
            return false;
        }
        int dotIndex = email.indexOf('.', atIndex);
        if (dotIndex == -1) {
            return false;
        }

        String domain = email.substring(atIndex + 1, dotIndex);
        return admin_domains.contains(domain);
    }
}
