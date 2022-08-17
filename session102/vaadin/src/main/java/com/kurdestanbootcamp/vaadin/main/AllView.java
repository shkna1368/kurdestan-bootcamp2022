package com.kurdestanbootcamp.vaadin.main;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "Allview", layout = MainLayout.class)
@PageTitle("AllView | Vaadin ")
public class AllView extends VerticalLayout {

    public AllView() {
        add(new Text("Welcome to MainView."));

        //make button


        Button largeButton = new Button("View Cateegory");
        largeButton.addThemeVariants(ButtonVariant.LUMO_LARGE);




        Button createButton = new Button("Create Category");
        createButton.addThemeVariants(ButtonVariant.LUMO_LARGE);





        Button normalButton = new Button("Normal");

        Button smallButton = new Button("Small");
        smallButton.addThemeVariants(ButtonVariant.LUMO_SMALL);

        HorizontalLayout buttonLayout = new HorizontalLayout(largeButton,normalButton,smallButton,createButton);

        smallButton.addClickListener(buttonClickEvent -> {

            smallButton.getUI().ifPresent(ui -> ui.navigate(MapView.class,123));


        });


        largeButton.addClickListener(buttonClickEvent -> {

    /*        largeButton.getUI().ifPresent(ui -> ui.navigate(
                    CarCategoryView.class));*/

        });

        createButton.addClickListener(buttonClickEvent -> {

       /*     createButton.getUI().ifPresent(ui -> ui.navigate(
                    CategoryCreatorView.class));*/

        });



        add(buttonLayout);

        //////////text field


        TextField textField = new TextField();
        textField.setClearButtonVisible(true);
        textField.setValue("Value");
        add(textField);

        /////////////////radio vertical
        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        radioGroup.setLabel("Travel class");
        radioGroup.setItems("Economy", "Business", "First Class");
        add(radioGroup);
        /////////////

        RadioButtonGroup<String> radioGroup2 = new RadioButtonGroup<>();
        radioGroup2.setLabel("Status");
        radioGroup2.setItems("Pending", "Submitted", "Confirmed");
        radioGroup2.setValue("Pending");
        add(radioGroup2);
        //////////////

        Checkbox checkbox = new Checkbox();
        checkbox.setLabel("I accept the terms and conditions");

        add(checkbox);

        ////////checkboxGroup

        CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
        checkboxGroup.setLabel("Export data");
        checkboxGroup.setItems("Order ID", "Product name", "Customer", "Status");
        checkboxGroup.select("Order ID", "Customer");
        checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        add(checkboxGroup);

        //////////////text area

        int  charLimit=200;
        TextArea textArea = new TextArea();
        textArea.setLabel("Comment");
        textArea.setMaxLength(charLimit);
        textArea.setValueChangeMode(ValueChangeMode.EAGER);
        textArea.addValueChangeListener(e -> {
            e.getSource().setHelperText(e.getValue().length() + "/" + charLimit);
        });
        textArea.setValue("Great job. This is excellent!");
        add(textArea);

///////////////////////////
        ComboBox<String> comboBox = new ComboBox<>("Country");
        comboBox.setItems("item1","Item2","Item3");
        comboBox.setItemLabelGenerator(String::toString);
        add(comboBox);


        /////////////grid

        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.addColumn(Person::getFirstName).setHeader("First name");
        grid.addColumn(Person::getLastName).setHeader("Last name");
        grid.addColumn(Person::getEmail).setHeader("Email");
        grid.addColumn(Person::getProfession).setHeader("Profession");

        List<Person> people = Person.seed();
        grid.setItems(people);

        add(grid);

        //////////


    }


}
