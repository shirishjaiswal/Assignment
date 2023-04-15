package org.sendmail;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String sender;
        String recipient;
        String subject;
        String message;
        String twoStepVerificationCode;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Sender Gmail id\t\t: ");
            sender = sc.nextLine().toLowerCase();
            while (isValid(sender)) {
                System.out.print("Email is incorrect\n" + "Re-enter your correct Gmail id\t: ");
                sender = sc.nextLine().toLowerCase();
            }
            System.out.print("Recipient Gmail id\t: ");
            recipient = sc.nextLine().toLowerCase();
            while (isValid(recipient)) {
                System.out.print("Email is incorrect\n" + "Re-enter recipients correct Gmail id\t: ");
                recipient = sc.nextLine().toLowerCase();
            }
            System.out.print("Subject\t\t\t\t: ");
            subject = sc.nextLine();
            System.out.print("Brief message\t\t: ");
            message = sc.nextLine();
            System.out.print("Verification Code\t: ");
            twoStepVerificationCode = sc.next();
        }


        HandleMail mail = new HandleMail(sender, recipient, subject, message, twoStepVerificationCode);
        mail.sendMail();
    }
    private static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return true;
        return !pat.matcher(email).matches();
    }
}
