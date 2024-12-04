package com.caldeira.projetofinal.zelda.fixtures;

import com.caldeira.projetofinal.zelda.models.GameListResponseModel;
import com.caldeira.projetofinal.zelda.models.GameModel;

import java.util.List;

public class TestFixtures {
    public static List<GameModel> getFixedGameListModel(){
        return List.of(
                new GameModel("5f6ce9d805615a85623ec2b7", " February 21, 1986", "The Legend of Zelda is the first installment of the Zelda series...", "Nintendo R&D 4", "Nintendo", " February 21, 1986"),
                new GameModel("5f6ce9d805615a85623ec2b8", "The Legend of Zelda: A Link to the Past", "One day, a band of evil thieves managed to open the gateway to the Sacred Realm, where the mystical Triforce was hidden. Upon finding the sacred golden relic, the leader of the thieves, Ganondorf, slew his followers and claimed it as his own. Before long, dark power began to flow forth from the Sacred Realm. People were drawn into this darkness, and never heard from again. As a result, the King of Hyrule ordered the seven sages to seal the entrance to the Sacred Realm. A great battle ensued—monsters poured into the Light World from the sacred land and attacked the castle. The Knights of Hyrule defended the sages during the great battle against evil, and, though most of them perished in the struggle, the sages were able to cast their seal, stopping the flow of darkness and trapping the evil king Ganon within. This battle became known as the Imprisoning War. ", "Nintendo", "Nintendo", " April 13, 1992"),
                new GameModel("5f6ce9d805615a85623ec2ba", "The Legend of Zelda: Ocarina of Time", "The Legend of Zelda: Ocarina of Time is the fifth main installment of The Legend of Zelda series and the first to be released for the Nintendo 64. It was one of the most highly anticipated games of its age. It is listed among the greatest video games ever created by numerous websites and magazines. Released in the United States on November 23, 1998, it was the first game in The Legend of Zelda series that was visually displayed in 3D . ", "Nintendo EAD", "Nintendo", " November 23, 1998"),
                new GameModel("5f6ce9d805615a85623ec2b9", "The Legend of Zelda: Oracle of Ages", "The Legend of Zelda: Oracle of Ages is one of two The Legend of Zelda  titles released for the Game Boy Color, the other being Oracle of Seasons, both representing the seventh and eighth main installments of the series. Released near the end of the system's lifespan, Oracle of Ages and its counterpart were said to \"send the Game Boy Color out with a bang.\" In anticipation of the upcoming release of the Game Boy Color's successor, the Game Boy Advance, the games exhibited special features  when played on the new handheld system. ", "Capcom", "Nintendo", " May 14, 2001"),
                new GameModel("5f6ce9d805615a85623ec2bb", "The Legend of Zelda: Link's Awakening DX", "The game was also made available on the Nintendo 3DS eShop on June 7, 2011 at the price of $5.99 US. ", "Nintendo", "Nintendo", " December 15, 1998")
        );
    }

    public static GameModel getByNameHyruleWarriors(){
        return new GameModel(
                "5f6ce9d805615a85623ec2d1",
                "Hyrule Warriors Legends",
                "Hyrule Warriors Legends is a spin-off for the Nintendo 3DS, combining the world of The Legend of Zelda series with the action of Koei Tecmo's Dynasty Warriors series. The game is a port and a new version of Hyrule Warriors, featuring new characters and other mechanical changes. ",
                "Omega Force",
                "Koei Tecmo",
                " March 25, 2016"
        );
    }
}
