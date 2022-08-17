package com.kurdestanbootcamp.vaadin.main;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "map", layout = MainLayout.class)
@PageTitle("MAP | Vaadin ")
public class MapView extends VerticalLayout  implements HasUrlParameter<Integer> {
Text text;

    public MapView() {
text=new Text("");
        add(text);




    }

    @Override
    public void setParameter(BeforeEvent event,
                                        Integer parameter) {
        if (parameter == null) {
            text.setText("Welcome anonymous.");
        } else {
            text.setText(String.format("Welcome %s.",
                    parameter));
        }
    }

}


