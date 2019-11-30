/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import static com.codename1.uikit.cleanmodern.SignInForm.connectedUser;
import com.esprit.EspritEntreAid.entities.User;
import com.esprit.EspritEntreAide.Service.UserService;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class SignUpForm extends BaseForm {

    public static TextField nom, prenom, email, password, confirmPassword, numtel, classe;
    public static ComboBox box;
    UserService ser = new UserService();

    public SignUpForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");

        nom = new TextField("", "Nom", 20, TextField.ANY);
        prenom = new TextField("", "Prenom", 20, TextField.ANY);
        email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        password = new TextField("", "Password", 20, TextField.PASSWORD);
        confirmPassword = new TextField("", "Confirm Password", 20, TextField.PASSWORD);
        numtel = new TextField("", "Numéro de telephone", 20, TextField.PHONENUMBER);
        classe = new TextField("", "Classe", 20, TextField.ANY);
        box = new ComboBox();
        nom.setSingleLineTextArea(true);
        prenom.setSingleLineTextArea(true);
        email.setSingleLineTextArea(true);
        password.setSingleLineTextArea(true);
        confirmPassword.setSingleLineTextArea(true);
        numtel.setSingleLineTextArea(true);
        classe.setSingleLineTextArea(true);

        Validator val = new Validator();

        val.addConstraint(nom, new LengthConstraint(4));
        String testnom = "^\\(?([a-z]{3})\\)?";
        val.addConstraint(nom, new RegexConstraint(testnom, ""));
        val.addConstraint(nom, new LengthConstraint(4));
        String testprenom = "^\\(?([a-z]{3})\\)?";
        val.addConstraint(prenom, new RegexConstraint(testprenom, ""));

        val.addConstraint(password, new LengthConstraint(4));
        val.addConstraint(confirmPassword, new LengthConstraint(4));

        val.addConstraint(classe, new LengthConstraint(20));
        String testclasse = "^\\(?([Tunisia ]{8})\\)?";
        val.addConstraint(classe, new RegexConstraint(testclasse, "Must be valid phone number"));

        val.addConstraint(numtel, new LengthConstraint(11));

        String testtel = "^\\(?([216]{3})\\)?([ .-]?)([0-9]{8})";
        val.addConstraint(numtel, new RegexConstraint(testtel, "Must be valid phone number"));

        val.addConstraint(email, RegexConstraint.validEmail());

        Button next = new Button("Next");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");

        Container content = BoxLayout.encloseY(
                new Label("Sign Up", "LogoLabel"),
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(prenom),
                createLineSeparator(),
                new FloatingHint(email),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                new FloatingHint(confirmPassword),
                createLineSeparator(),
                createLineSeparator(),
                new FloatingHint(numtel),
                createLineSeparator(),
                new FloatingHint(classe),
                createLineSeparator(),
                createLineSeparator()
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
        next.requestFocus();
        //e -> new ActivateForm(res).show()
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                User user = new User(nom.getText(), prenom.getText(), email.getText(), password.getText(), numtel.getText(), classe.getText());
                ser.ajoutUser(user);
                Dialog.show("Bienvenue", "Inscription effectuée avec succés", "Ok", null);

                SignInForm menu = new SignInForm(res);
                menu.show();

            }
        });
    }

}
//    public SignUpForm(Resources res) {
//        super(new BorderLayout());
//        Toolbar tb = new Toolbar(true);
//        setToolbar(tb);
//        tb.setUIID("Container");
//        getTitleArea().setUIID("Container");
//        Form previous = Display.getInstance().getCurrent();
//        tb.setBackCommand("", e -> previous.showBack());
//        setUIID("SignIn");
//                
//        TextField username = new TextField("", "Username", 20, TextField.ANY);
//        TextField email = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
//        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
//        TextField confirmPassword = new TextField("", "Confirm Password", 20, TextField.PASSWORD);
//        username.setSingleLineTextArea(false);
//        email.setSingleLineTextArea(false);
//        password.setSingleLineTextArea(false);
//        confirmPassword.setSingleLineTextArea(false);
//        Button next = new Button("Next");
//        Button signIn = new Button("Sign In");
//        signIn.addActionListener(e -> previous.showBack());
//        signIn.setUIID("Link");
//        Label alreadHaveAnAccount = new Label("Already have an account?");
//        
//        Container content = BoxLayout.encloseY(
//                new Label("Sign Up", "LogoLabel"),
//                new FloatingHint(username),
//                createLineSeparator(),
//                new FloatingHint(email),
//                createLineSeparator(),
//                new FloatingHint(password),
//                createLineSeparator(),
//                new FloatingHint(confirmPassword),
//                createLineSeparator()
//        );
//        content.setScrollableY(true);
//        add(BorderLayout.CENTER, content);
//        add(BorderLayout.SOUTH, BoxLayout.encloseY(
//                next,
//                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
//        ));
//        next.requestFocus();
//        next.addActionListener(e -> new ActivateForm(res).show());
//    }
//    
//}
