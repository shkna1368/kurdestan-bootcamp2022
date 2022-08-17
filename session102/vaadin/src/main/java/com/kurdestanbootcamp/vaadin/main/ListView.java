package com.kurdestanbootcamp.vaadin.main;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="List", layout = MainLayout.class)
@PageTitle("Contacts | Vaadin ")
public class ListView extends VerticalLayout {

}