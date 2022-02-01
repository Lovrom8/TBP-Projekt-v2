package com.lp.tbp_projekt.v2.api;

import com.lp.tbp_projekt.v2.api.models.*;
import com.lp.tbp_projekt.v2.api.repository.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataGeneratorImpl implements DataGenerator
{
    private final UserRepository userRepo;
    private final AlbumRepository albumRepo;
    private final ArtistRepository artistRepo;
    private final SongRepository songRepo;
    private final GenreRepository genreRepo;
    private final SubgenreRepository subgenreRepo;

    public DataGeneratorImpl(UserRepository userRepo,
                         AlbumRepository albumRepo,
                         ArtistRepository artistRepo,
                         SongRepository songRepo,
                         GenreRepository genreRepo,
                         SubgenreRepository subgenreRepository)
    {
        this.userRepo = userRepo;
        this.albumRepo = albumRepo;
        this.genreRepo = genreRepo;
        this.songRepo = songRepo;
        this.artistRepo = artistRepo;
        this.subgenreRepo = subgenreRepository;
    }


    @Override
    public void generateData()
    {
        Artist artistOpeth = artistRepo.save(new Artist("Opeth", "Sweden"));
        Artist artistPantera = artistRepo.save(new Artist("Pantera", "USA"));
        Artist artistSepultura = artistRepo.save(new Artist("Sepultura", "Brazil"));
        Artist artistAbba = artistRepo.save(new Artist("Abba", "Sweden"));
        Artist artistEWF = artistRepo.save(new Artist("Earth, Wind & Fire", "USA"));
        Artist artistKylieMinoque = artistRepo.save(new Artist("Kylie Minogue", "Australia"));
        Artist artistSabaton = artistRepo.save(new Artist("Sabaton", "Sweden"));
        Artist artistKingCrimson = artistRepo.save(new Artist("King Crimson", "UK"));
        Artist artistCrackTheSky = artistRepo.save(new Artist("Crack the Sky", "USA"));
        Artist artistEminem = artistRepo.save(new Artist("Eminem", "USA"));
        Artist artistHollywoodUndead = artistRepo.save(new Artist("Hollywood Undead", "USA"));
        Artist artistLilUzi = artistRepo.save(new Artist("Lil Uzi Vert", "USA"));
        Artist artistLynchHung = artistRepo.save(new Artist("Brotha Lynch Hung", "USA"));
        Artist artistSade = artistRepo.save(new Artist("Sade", "UK"));
        Artist artistDjangoReinhardt = artistRepo.save(new Artist("Django Reinhardt", "Belgium"));
        Artist artistEddiePalmieri = artistRepo.save(new Artist("Eddie Palmieri", "USA"));
        Artist artistBabymetal = artistRepo.save(new Artist("Babymetal", "Japan"));
        Artist artistArashi = artistRepo.save(new Artist("Arashi", "Japan"));
        Artist artistTaylorSwift = artistRepo.save(new Artist("Taylor Swift", "USA"));

        Album albumWatershed = albumRepo.save(new Album("Heritage", artistOpeth, "https://upload.wikimedia.org/wikipedia/en/e/ee/Opeth_-_Watershed.jpg"));
        Album albumCowboys = albumRepo.save(new Album("Cowboys From Hell", artistPantera, "https://upload.wikimedia.org/wikipedia/en/a/a8/CowboysFromHell.jpg"));
        Album albumChaosAD = albumRepo.save(new Album("Chaos AD", artistSepultura, "https://upload.wikimedia.org/wikipedia/en/c/cf/Sepultura_-_Chaos_A.D._1993.jpg"));
        Album albumFever = albumRepo.save(new Album("Fever", artistKylieMinoque, "https://upload.wikimedia.org/wikipedia/en/a/a9/Kylie_Minogue_-_Fever.png"));
        Album albumVolez = albumRepo.save(new Album("Volez-Vous", artistAbba, "https://upload.wikimedia.org/wikipedia/en/6/61/ABBA_-_Voulez_Vous.jpg"));
        Album albumArrival = albumRepo.save(new Album("Arrival", artistAbba, "https://upload.wikimedia.org/wikipedia/en/7/71/ABBA_-_Arrival.png"));
        Album albumIAm = albumRepo.save(new Album("I am", artistEWF, "https://upload.wikimedia.org/wikipedia/en/f/fb/IAmAlbumCover.jpg"));
        Album albumCarolusRex = albumRepo.save(new Album("Carolus Rex", artistSabaton, "https://upload.wikimedia.org/wikipedia/en/0/06/Sabaton_Carolus_Rex.jpg"));
        Album albumHeroes = albumRepo.save(new Album("Heroes", artistSabaton, "https://upload.wikimedia.org/wikipedia/en/f/f9/Sabaton_Alblem_cover.jpg"));
        Album albumDiscipline = albumRepo.save(new Album("Discipline", artistKingCrimson, "https://upload.wikimedia.org/wikipedia/en/c/c1/Discipline_-_Original_Vinyl_Cover.jpg"));
        Album albumCrackTheSky = albumRepo.save(new Album("Crack the Sky", artistCrackTheSky, "https://upload.wikimedia.org/wikipedia/en/9/91/Ctscts.jpg"));
        Album album8Mile = albumRepo.save(new Album("8 Mile", artistEminem, "https://upload.wikimedia.org/wikipedia/en/3/39/8milecover.jpg"));
        Album albumSwanSongs = albumRepo.save(new Album("Swan Songs", artistHollywoodUndead, "https://upload.wikimedia.org/wikipedia/en/6/6a/Hollywoodundeadswansongs.jpg"));
        Album albumEternalAtake = albumRepo.save(new Album("Eternal Atake", artistLilUzi, "https://upload.wikimedia.org/wikipedia/en/1/1f/Eternal_Atake_Lil_Uzi_Vert.jpg"));
        Album albumDemonHigh = albumRepo.save(new Album("Demon High", artistLilUzi, "https://upload.wikimedia.org/wikipedia/en/0/0a/Lil_Uzi_Vert_-_Demon_High.jpg"));
        Album albumBook3 = albumRepo.save(new Album("Book III", artistLynchHung, "https://upload.wikimedia.org/wikipedia/en/4/40/Book_III.jpg"));
        Album albumDiamondLife = albumRepo.save(new Album("Diamond Life", artistSade, "https://upload.wikimedia.org/wikipedia/en/6/69/Sade_-_Diamond_Life.png"));
        Album albumParis45 = albumRepo.save(new Album("Paris 1945", artistDjangoReinhardt, "https://upload.wikimedia.org/wikipedia/en/1/15/Paris_1945.jpeg"));
        Album albumJusticia = albumRepo.save(new Album("Justicia", artistEddiePalmieri, "https://upload.wikimedia.org/wikipedia/en/b/b8/Justicia_by_Eddie_Palmieri.jpg"));
        Album albumBabymetal = albumRepo.save(new Album("Babymetal", artistBabymetal, "https://upload.wikimedia.org/wikipedia/en/3/36/Babymetalcover.jpg"));
        Album albumPopcorn = albumRepo.save(new Album("Popcorn", artistArashi, "https://upload.wikimedia.org/wikipedia/en/c/ce/%E5%B5%90_-_Popcorn.jpg"));
        Album albumRed = albumRepo.save(new Album("Red", artistTaylorSwift, "https://upload.wikimedia.org/wikipedia/en/e/e8/Taylor_Swift_-_Red.png"));

        Genre genreHM = genreRepo.save(new Genre("Heavy metal"));
        Genre genreRock = genreRepo.save(new Genre("Rock"));
        Genre genreHP = genreRepo.save(new Genre("Hip-hop"));
        Genre genreJazz = genreRepo.save(new Genre("Jazz"));
        Genre genreRNB = genreRepo.save(new Genre("R&B"));
        Genre genrePop = genreRepo.save(new Genre("Pop"));

        Subgenre sbPowerMetal = subgenreRepo.save(new Subgenre("Power metal"));
        Subgenre sbDeathMetal = subgenreRepo.save(new Subgenre("Death metal"));
        Subgenre sbProgMetal = subgenreRepo.save(new Subgenre("Progressive metal"));
        Subgenre sbThrashMetal = subgenreRepo.save(new Subgenre("Thrash metal"));
        Subgenre sbGrooveMetal = subgenreRepo.save(new Subgenre("Groove metal"));

        Subgenre sbRock = subgenreRepo.save(new Subgenre("Rock"));
        Subgenre sbProgRock = subgenreRepo.save(new Subgenre("Progressive rock"));
        Subgenre sbHardRock = subgenreRepo.save(new Subgenre("Hard rock"));
        Subgenre sbRapRock = subgenreRepo.save(new Subgenre("Rap rock"));

        Subgenre sbGangsta = subgenreRepo.save(new Subgenre("Gangsta rap"));
        Subgenre sbMumble = subgenreRepo.save(new Subgenre("Mumble rap"));
        Subgenre sbHardcoreRap = subgenreRepo.save(new Subgenre("Hardcore rap"));

        Subgenre sbSmoothJazz = subgenreRepo.save(new Subgenre("Smooth jazz"));
        Subgenre sbGypsyJazz = subgenreRepo.save(new Subgenre("Gypsy jazz"));
        Subgenre sbSwingJazz = subgenreRepo.save(new Subgenre("Swing jazz"));
        Subgenre sbLatinJazz = subgenreRepo.save(new Subgenre("Latin jazz"));

        Subgenre sbDisco = subgenreRepo.save(new Subgenre("Disco"));
        Subgenre sbFunk = subgenreRepo.save(new Subgenre("Funk"));
        Subgenre sbSoul = subgenreRepo.save(new Subgenre("Soul"));

        Subgenre sbEuropop = subgenreRepo.save(new Subgenre("Europop"));
        Subgenre sbJPop = subgenreRepo.save(new Subgenre("J-pop"));
        Subgenre sbCountryPop = subgenreRepo.save(new Subgenre("Country pop"));
        //endregion

        Song songHeirApparent = songRepo.save(new Song("Heir Apparent", genreHM, albumWatershed, Arrays.asList(sbDeathMetal, sbProgMetal)));
        Song songCGates = songRepo.save(new Song("Cemetery Gates", genreHM, albumCowboys, Arrays.asList(sbThrashMetal, sbGrooveMetal)));
        Song songRefuse = songRepo.save(new Song("Refuse/Resist", genreHM, albumChaosAD, List.of(sbGrooveMetal)));
        Song songCR = songRepo.save(new Song("Carolus Rex", genreHM, albumCarolusRex, List.of(sbPowerMetal)));

        Song songSoldier = songRepo.save(new Song("Soldier of 3 Armies", genreHM, albumHeroes, List.of(sbPowerMetal)));
        Song songHearts = songRepo.save(new Song("Hearts of Iron", genreHM, albumHeroes, List.of(sbPowerMetal)));
        Song songSnakes = songRepo.save(new Song("Smoking Snakes", genreHM, albumHeroes, List.of(sbPowerMetal)));

        Song songCant = songRepo.save(new Song("Can't Get You Out of My Head", genrePop, albumFever, Arrays.asList(sbEuropop, sbDisco)));
        Song songGimme = songRepo.save(new Song("Gimme gimme gimme", genrePop, albumVolez, Arrays.asList(sbEuropop, sbDisco)));
        Song songDancing = songRepo.save(new Song("Dancing Queen", genrePop, albumArrival, Arrays.asList(sbEuropop, sbDisco)));

        Song songBoogie = songRepo.save(new Song("Boogie Wonderland", genreRNB, albumIAm, Arrays.asList(sbSoul, sbDisco, sbFunk)));
        Song songCantLet = songRepo.save(new Song("Can't Let Go", genreRNB, albumIAm, Arrays.asList(sbSoul, sbDisco, sbFunk)));
        Song songInTheStone = songRepo.save(new Song("In the Stone", genreRNB, albumIAm, Arrays.asList(sbSoul, sbDisco, sbFunk)));

        /*songRepo.save(new Song("Elephant Talk", genreRock, albumDiscipline, List.of(sbProgRock)));
        songRepo.save(new Song("Frame by Frame", genreRock, albumDiscipline, List.of(sbProgRock)));
        songRepo.save(new Song("Indiscipline", genreRock, albumDiscipline, List.of(sbProgRock)));

        songRepo.save(new Song("Sea Epic", genreRock, albumCrackTheSky, Arrays.asList(sbHardRock, sbProgRock)));
        songRepo.save(new Song("She's a Dancer", genreRock, albumCrackTheSky, Arrays.asList(sbHardRock, sbProgRock)));
        songRepo.save(new Song("Hold On", genreRock, albumCrackTheSky, Arrays.asList(sbHardRock, sbProgRock)));

        songRepo.save(new Song("Lose yourself", genreHP, album8Mile, Arrays.asList(sbRapRock, sbHardcoreRap)));
        songRepo.save(new Song("Undead", genreRock, albumSwanSongs, List.of(sbRapRock)));
        songRepo.save(new Song("Everywhere I Go", genreRock, albumSwanSongs, List.of(sbRapRock)));

        songRepo.save(new Song("Demon High", genreHP, albumDemonHigh, List.of(sbMumble)));
        songRepo.save(new Song("Pop", genreHP, albumEternalAtake, List.of(sbMumble)));
        songRepo.save(new Song("Lo mein", genreHP, albumEternalAtake, List.of(sbMumble)));
        songRepo.save(new Song("Homecoming", genreHP, albumEternalAtake, List.of(sbMumble)));

        songRepo.save(new Song("Evidence 2002", genreHP, albumBook3, Arrays.asList(sbGangsta, sbHardcoreRap)));
        songRepo.save(new Song("Savage Wayz", genreHP, albumBook3, Arrays.asList(sbGangsta, sbHardcoreRap)));
        songRepo.save(new Song("Refuse to Lose", genreHP, albumBook3, Arrays.asList(sbGangsta, sbHardcoreRap)));

        songRepo.save(new Song("Smooth Operator", genreJazz, albumDiamondLife, Arrays.asList(sbSmoothJazz, sbSoul)));
        songRepo.save(new Song("Cherry Pie", genreJazz, albumDiamondLife, Arrays.asList(sbSmoothJazz, sbSoul)));
        songRepo.save(new Song("I Will Be Your Friend", genreJazz, albumDiamondLife, Arrays.asList(sbSmoothJazz, sbSoul)));

        songRepo.save(new Song("If Dreams Come True", genreJazz, albumParis45, Arrays.asList(sbSwingJazz, sbGypsyJazz)));
        songRepo.save(new Song("Sugar", genreJazz, albumParis45, Arrays.asList(sbSwingJazz, sbGypsyJazz)));

        songRepo.save(new Song("Justicia", genreJazz, albumJusticia, List.of(sbLatinJazz)));
        songRepo.save(new Song("Amor ciego", genreJazz, albumJusticia, List.of(sbLatinJazz)));

        songRepo.save(new Song("Gimme Chocolate!!", genreHM, albumBabymetal, Arrays.asList(sbJPop, sbPowerMetal)));
        songRepo.save(new Song("Headbangeeeeerrrrr!!!!!", genreHM, albumBabymetal, Arrays.asList(sbJPop, sbPowerMetal)));
        songRepo.save(new Song("Welcome to Our Party", genreRNB, albumPopcorn, List.of(sbJPop)));
        songRepo.save(new Song("Your Eyes", genreRNB, albumPopcorn, List.of(sbJPop)));

        songRepo.save(new Song("Red", genrePop, albumRed, Arrays.asList(sbCountryPop, sbRock)));
        songRepo.save(new Song("The Last Time", genrePop, albumRed, List.of(sbRock)));*/

        User user1 = new User("Lovro", "Posarić", "lovrom8", "uVhgF0Q9uHHEwF+87AGsPQ==.ICagYzxSbHyXMmGvDvKmzh79fhjFuQ1DjsCAGM8e9BY=", "lovro@rm.com");
        User user2 = new User("Tester", "Testerić", "test1234", "lTwKXwSIoBkK1zCQqIL3rA==.tmfmid04bY856v4qSTVH1L6G9qZEdLwO81gk8rfLfWc=", "lovrot@rm.com");
        User user3 = new User("Korisnik", "Treći", "test3", "lTwKXwSIoBkK1zCQqIL3rA==.tmfmid04bY856v4qSTVH1L6G9qZEdLwO81gk8rfLfWc=", "test3@rm.com");
        User user4 = new User("Korisnik", "Četvrti", "test4", "lTwKXwSIoBkK1zCQqIL3rA==.tmfmid04bY856v4qSTVH1L6G9qZEdLwO81gk8rfLfWc=", "test4@rm.com");
        User user5 = new User("Korisnik", "Peti", "test5", "lTwKXwSIoBkK1zCQqIL3rA==.tmfmid04bY856v4qSTVH1L6G9qZEdLwO81gk8rfLfWc=", "test5@rm.com");

        user1.addRating(new Rating(songCR, 5));
        user1.addRating(new Rating(songCGates, 4));
        user2.addRating(new Rating(songCGates, 5));
        user2.addRating(new Rating(songSnakes, 1));
        user2.addRating(new Rating(songSoldier, 5));
        user3.addRating(new Rating(songCR, 2));
        user3.addRating(new Rating(songBoogie, 5));
        user3.addRating(new Rating(songGimme, 4));
        user3.addRating(new Rating(songHearts, 2));

        userRepo.save(user1);
        userRepo.save(user2);

        for (User user : userRepo.findAll())
        {
            System.out.println(user.getEmail());
        }
    }

    @Override
    public void deleteExistingData()
    {
        userRepo.deleteAll();
        albumRepo.deleteAll();
        genreRepo.deleteAll();
        subgenreRepo.deleteAll();
        songRepo.deleteAll();
        artistRepo.deleteAll();
    }
}
