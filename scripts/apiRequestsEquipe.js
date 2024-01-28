const axios = require('axios');

const url = 'http://localhost:8080';

async function createEquipe(nom, joueurs) {
    try {
        const response = await axios.post(`${url}/equipes`,
            {
                nom: nom,
                joueurs: joueurs
            });
        console.log("L'équipe " + nom + " a été créée :");
        console.log(response.data);
        return response.data
    } catch (error) {
        console.error("L'équipe n'a pas pu être créée à cause de :");
        throw error;
    }
}

async function getAllEquipes() {
    try {
        const response = await axios.get(`${url}/equipes`);
        console.log("Voici la liste des équipes : ");
        response.data.forEach(equipe => {
            console.log(` - ${equipe.id}, ${equipe.nom}`);

            // Afficher la liste des joueurs de l'équipe
            equipe.joueurs.forEach(joueur => {
                console.log(`   * ${joueur.id}, ${joueur.nom}, ${joueur.prenom}, ${joueur.dateDeNaissance}, ${JSON.stringify(joueur.equipe)}`);
            });
        });
    } catch (error) {
        console.error("Les équipes n'ont pas pu être récupérées :");
        console.error(error);
    }
}

async function getEquipe(idEquipe) {
    try {
        const response = await axios.get(`${url}/equipes/${idEquipe}`);
        console.log("Récupérer l'équipe avec l'id " + idEquipe )
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}

async function deleteEquipe(idEquipe) {
    try {
        const response = await axios.delete(`${url}/equipes/${idEquipe}`);
        console.log("L'équipe avec l'id "+ idEquipe + " a été supprimée")
        return response.data;
    } catch (error) {
        console.error(error);
    }
}
async function putEquipe(nouvelleEquipe,idEquipe) {
    try {
        const response = await axios.put(`${url}/equipes/${idEquipe}`, nouvelleEquipe);
        console.log("Modification de l'équipe avec l'id " + idEquipe)
        return response.data
    } catch (error) {
        console.error(error);
    }
}

module.exports = {
    createEquipe,
    getAllEquipes,
    getEquipe,
    deleteEquipe,
    putEquipe
};
