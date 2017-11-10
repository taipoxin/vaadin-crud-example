package by.tiranid.crudui.ui;

import by.tiranid.crudui.repositories.CustomerRepository;
import by.tiranid.crudui.mappings.Customer;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;


//@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    CustomerRepository repo;
    Grid<Customer> grid;

    @Autowired
    public VaadinUI(CustomerRepository repo) {

        this.repo = repo;
        this.grid = new Grid<>(Customer.class);
    }

    @Override
    protected void init(VaadinRequest request) {
        // to place grid on the center
        VerticalLayout vLayout = new VerticalLayout();
        SignInPanel signInPanel = new SignInPanel(grid);
        vLayout.addComponent(signInPanel);
        vLayout.setSizeFull();
        vLayout.setComponentAlignment(signInPanel, Alignment.MIDDLE_CENTER);

        this.setContent(vLayout);
        listCustomers();
    }



    private void listCustomers() {
        grid.setItems(repo.findAll());
    }

    class SignInPanel extends Panel  {

        public SignInPanel(Component content) {
            this.setSizeUndefined();
            this.setContent(content);
        }
    }


}
