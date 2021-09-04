package com.drronidz.tools;

/*
PROJECT NAME : PointOfSaleFX
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 9/1/2021 3:12 PM
*/

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import org.kordamp.ikonli.javafx.FontIcon;

public class Validator {
    final private static String NAME_REGEX = "[a-zA-Z ]{3,30}";
    final private static String CANNOT_BE_EMPTY = " cannot be empty";
    RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator();

    public void textFieldValidate(JFXTextField textField) {
        validateRequiredTextField(textField);
        validateTextFieldWithRegEx(textField);
        textFieldFocusChangeListener(textField);
        textFieldTextChangeListener(textField);
    }
    public void  textAreaValidator(JFXTextArea textArea) {
        validateRequiredTextArea(textArea);
        textAreaFocusChangeListener(textArea);
        textAreaTextChangeListener(textArea);
    }

    private void validateRequiredTextField(JFXTextField textField) {
        String textFieldName = textField.getPromptText();
        requiredFieldValidator.setMessage("!" + textFieldName + CANNOT_BE_EMPTY);
        textField.getValidators().add(requiredFieldValidator);
    }
    private void validateTextFieldWithRegEx(JFXTextField textField) {
        String textFieldName = textField.getPromptText();
        RegexValidator regexValidator = new RegexValidator();
        String [] fieldCategory = textFieldName.toLowerCase().split(" ",2);
        String fieldName = fieldCategory[1];
        switch (fieldName) {
            case "name" : {
                regexValidator.setRegexPattern(NAME_REGEX);
                regexValidator.setMessage("!" + textFieldName + " cannot contain: numbers, special chars");
            }
            break;

        }
        textField.getValidators().addAll(regexValidator);
    }

    private void validateRequiredTextArea(JFXTextArea textArea) {
        String nodeName = textArea.getPromptText();
        requiredFieldValidator.setMessage("!" + nodeName + CANNOT_BE_EMPTY);
        textArea.getValidators().addAll(requiredFieldValidator);
    }
    private void validateTextAreaWithRegEx(JFXTextArea textArea) {}

    private void textFieldFocusChangeListener (JFXTextField textField) {
        textField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                textField.validate();
            }
        });
    }
    private void textFieldTextChangeListener (JFXTextField textField) {
        textField.textProperty().addListener((o, oldVal, newVal) ->
                textField.validate());
    }

    private void textAreaFocusChangeListener (JFXTextArea textArea) {
        textArea.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                textArea.validate();
            }
        });
    }
    private void textAreaTextChangeListener(JFXTextArea textArea) {
        textArea.textProperty().addListener((o, oldVal, newVal) ->
                textArea.validate());
    }
}
