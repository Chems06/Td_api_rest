const axios = require('axios');

const url = 'http://localhost:8080';

async function createJoueur(nom, prenom, dateDeNaissance, equipeId) {
    try {
        const response = await axios.post(`${url}/joueurs`,
            {
                nom: nom,
                prenom: prenom,
                dateDeNaissance: dateDeNaissance,
                equipe: {id: equipeId}
            });
        console.log("Joueur " + response.data.nom + " est créé")
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.error("Le joueur n'a pas pu être créé à cause de :");
        throw error;
    }
}

async function getAllJoueurs() {
    try {
        const response = await axios.get(`${url}/joueurs`);
        console.log("Voici la liste des joueurs : ");
        response.data.forEach(joueur => {
            console.log(` - ${joueur.id}, ${joueur.nom}, ${joueur.prenom}, ${joueur.dateDeNaissance}, ${JSON.stringify(joueur.equipe)}`);
        });
        return response.data;
    } catch (error) {
        console.error(error);
    }
}

async function getJoueur(idJoueur) {
    try {
        const response = await axios.get(`${url}/joueurs/${idJoueur}`);
        console.log("Récupérer le joueur avec l'id " + idJoueur)
        console.log(response.data);
    } catch (error) {
        console.error(error);
    }
}

async function deleteJoueur(idJoueur) {
    try {
        const response = await axios.delete(`${url}/joueurs/${idJoueur}`);
        console.log("Le joueur avec l'id "+ idJoueur + " a été supprimé")
        return response.data;
    } catch (error) {
        console.error(error);
    }
}

async function putJoueur(nouveauJoueur,idJoueur) {
    try {
        const response = await axios.put(`${url}/joueurs/${idJoueur}`, nouveauJoueur);
        console.log("Modification du joueur avec l'id " + idJoueur)
        return response.data
    } catch (error) {
        console.error(error);
    }
}

module.exports = {
    createJoueur,
    getAllJoueurs,
    getJoueur,
    deleteJoueur,
    putJoueur,
};
