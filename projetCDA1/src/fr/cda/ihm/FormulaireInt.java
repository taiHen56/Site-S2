package fr.cda.ihm;

/** Interface d'utilisation d'un formulaire.<br>
    L'applicatif passer en paramtre du formulaire doit 
    implmenter cette interface. */
public interface FormulaireInt
{
    /** Cette mthode est appelee lors de l'utilsation d'un bouton.<br>
        L'appel a form.getValeurChamp permet de recuperer les valeurs des champs.<br>
        L'appel a form.setValeurChamp permet de changer les valeurs des champs.<br>
        @param form Le formulaire dans lequel se trouve le bouton
        @param nom Le nom du bouton qui a t utilis.
     */
    public void     submit(Formulaire form,String nom);
}
