package org.vaadin.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import lombok.extern.slf4j.Slf4j;

@Route
@Slf4j
@CssImport("./styles/styles.css")
public class MainView extends AppLayout {

    public MainView() {
        try {
            createHeader();
            createDrawer();
            setContent(createContent());
        } catch (Exception e) {
            log.error("UI loading error", e);
        }
    }

    private void createHeader() {
        H1 logo = new H1("Музеи");
        logo.addClassNames("header-logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.addClassName("app-layout-navbar");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-l", "px-m");

        addToNavbar(header);
    }

    private void createDrawer() {
        VerticalLayout menu = new VerticalLayout();
        menu.addClassName("nav-link");
        menu.setSizeFull();
        menu.setPadding(false);
        menu.setSpacing(false);
        menu.add(new RouterLink("Главная", MainView.class));
        addToDrawer(menu);
    }

    private Component createContent() {
        FlexLayout tiles = new FlexLayout();
        tiles.addClassName("tiles");
        tiles.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        tiles.setWidthFull();

        for (int i = 0; i < 6; i++) {
            tiles.add(createTile("https://xn--e1aogg7a.xn--p1ai/upload/iblock/32e/32ec91e3d29d909616f880de3e9dcd69.JPG", "МУЗЕЙ «ДОМ И.А. МИЛЮТИНА»", "https://xn--e1aogg7a.xn--p1ai/museums/muzey-milyutina/"));
            tiles.add(createTile("https://xn--e1aogg7a.xn--p1ai/upload/iblock/32c/32c3bba9b32f4080e4f93b44ef2b2a28.jpg", "МУЗЕЙ ВОЕННОЙ ТЕХНИКИ «ПАРК ПОБЕДЫ»", "https://xn--e1aogg7a.xn--p1ai/museums/muzey-voennoy-tekhniki-park-pobedy/"));
            tiles.add(createTile("https://xn--e1aogg7a.xn--p1ai/upload/iblock/f58/f58c422bad62a2abf9c1772bf39f2cee.jpg", "МУЗЕЙ АПТЕКИ", "https://xn--e1aogg7a.xn--p1ai/museums/muzey-apteki/"));
            tiles.add(createTile("https://xn--e1aogg7a.xn--p1ai/upload/iblock/32c/32c3bba9b32f4080e4f93b44ef2b2a28.jpg", "МУЗЕЙ ВОЕННОЙ ТЕХНИКИ «ПАРК ПОБЕДЫ»", "https://xn--e1aogg7a.xn--p1ai/museums/muzey-voennoy-tekhniki-park-pobedy/"));
            tiles.add(createTile("https://xn--e1aogg7a.xn--p1ai/upload/iblock/f58/f58c422bad62a2abf9c1772bf39f2cee.jpg", "МУЗЕЙ АПТЕКИ", "https://xn--e1aogg7a.xn--p1ai/museums/muzey-apteki/"));
        }

        return tiles;
    }

    private Component createTile(String imageUrl, String text, String linkUrl) {
        Image image = new Image(imageUrl, "placeholder");
        image.addClassName("tile-image");

        Anchor link = new Anchor(linkUrl, "Подробно");
        link.addClassName("tile-link");

        Div textLabel = new Div();
        textLabel.setText(text);
        textLabel.addClassName("tile-text");

        Div textOverlay = new Div(textLabel, link);
        textOverlay.addClassName("tile-overlay");

        Div container = new Div(image, textOverlay);
        container.addClassName("tile");
        return container;
    }

}
