package com.kurdestanbootcamp.vaadin.main;

import com.kurdestanbootcamp.vaadin.post_service.PostDTO;
import com.kurdestanbootcamp.vaadin.post_service.PostProxy;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "PostView", layout = MainLayout.class)
@PageTitle("Post | Vaadin ")
public class PostView extends VerticalLayout {

    Grid<PostDTO> grid;

    PostProxy postService;
    TextField textFieldTitle;


    public PostView(PostProxy postService){
        this.postService=postService;

        textFieldTitle = new TextField();
        textFieldTitle.setClearButtonVisible(true);
        textFieldTitle.setValue("Title");

        Button createButton = new Button("Save");
        createButton.addThemeVariants(ButtonVariant.LUMO_LARGE);

        createButton.addClickListener(buttonClickEvent -> {
            String title=textFieldTitle.getValue();

            PostDTO postDTO=new PostDTO();
            postDTO.setTitle(title);
            postService.save(postDTO);
            System.out.println("success done");
            Notification notification = Notification.show("Successfully submitted!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            fillGrid();

        });



        HorizontalLayout creatLayout = new HorizontalLayout(textFieldTitle,createButton);

        add(creatLayout);




        /////////////////make grid


        grid = new Grid<>(PostDTO.class, false);
        grid.addColumn(PostDTO::getId).setHeader("Id");
        grid.addColumn(PostDTO::getTitle).setHeader("Title");




        grid.addSelectionListener(selectionEvent -> {
            selectionEvent.getFirstSelectedItem().ifPresent(carCategory -> {
                Notification.show(carCategory.getId() + " is selected");
            });
        });

        fillGrid();


        add(grid);
    }

    public  void fillGrid(){

        List<PostDTO> postDTOList= postService.getAll();

        grid.setItems(postDTOList);
    }




}
