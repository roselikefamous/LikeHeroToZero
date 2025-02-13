package likeherotozero;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.persistence.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private Scientist loggedScientist;

    // Getter & Setter
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Scientist getLoggedScientist() {
        return loggedScientist;
    }

    // Einfache Login-Methode (nicht für Produktionseinsatz geeignet)
    public String doLogin() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeHeroPU");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Scientist> query = em.createQuery(
                    "SELECT s FROM Scientist s WHERE s.username = :username AND s.password = :password",
                    Scientist.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            try {
                loggedScientist = query.getSingleResult();
                // Weiterleitung zur Seite 'addEmission.xhtml'
                return "addEmission?faces-redirect=true";
            } catch (NoResultException ex) {
                // Login fehlgeschlagen, bleibe auf der Login-Seite
                return "login?faces-redirect=true";
            }
        } finally {
            em.close();
            emf.close();
        }
    }


    public String logout() {

        loggedScientist = null;


        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }


        return "index?faces-redirect=true";
    }
}
