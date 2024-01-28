const {createJoueur, getAllJoueurs, getJoueur, deleteJoueur, putJoueur} = require("./apiRequestsJoueur");
const {createEquipe, getAllEquipes, getEquipe, deleteEquipe, putEquipe} = require("./apiRequestsEquipe");


async function main() {
    try {
        const joueurs = []
        const nouveauJoueur = {
            nom: "Yoshino",
            prenom: "Nakashima ",
            dateDeNaissance: "1999-07-27",
            equipe: {
                id: 3
            }
        }
        const nouvelleEquipe = {
            nom: "Japan Modifiée",
            joueurs: joueurs
        }
        // Création des équipes
        const france = await createEquipe('France', joueurs);
        const maroc = await createEquipe('Maroc', joueurs);
        const japan = await createEquipe('Japan', joueurs);

        // Création des joueurs
        await createJoueur("Ayane", "Rosella", "1996-03-16", maroc.id);
        await createJoueur("Nouhaila", "Benzina", "1998-05-11", maroc.id);
        await createJoueur("Lakrar", "Maelle", "2000-05-27", france.id);
        await createJoueur("Wendie", "Renard", "1990-07-20", france.id);
        await createJoueur("Hasegawa", "Yui", "1997-01-29", japan.id);
        await createJoueur("Risa", "Shimizu", "1996-06-15", japan.id);

        console.log("Liste des équipes après la création des joueurs!")
        await getAllEquipes()

        // Récupérer tous les joueurs
        await getAllJoueurs();

        // Récupérer un joueur en particulier
        await getJoueur(1);

        // Suppression d'un joueur en particulier
        await deleteJoueur(2);

        // Modification d'un joueur
        await putJoueur(nouveauJoueur,5)

        // Récupérer tous les joueurs après les modifications
        console.log("La liste finale des joueurs après les modifications : ")
        await getAllJoueurs()

        // Suppression d'une équipe
        await deleteEquipe(2)
        await putEquipe(nouvelleEquipe,3)
        await getEquipe(3)

        // Récupérer toutes les équipes après suppression
        await getAllEquipes()
        await getAllJoueurs()
        console.log("le joueur dans l'équipe qui vient d'être supprimée est aussi supprimé!")

    } catch (error) {
        console.error("Une erreur s'est produite :", error.message);
    }
}

main();