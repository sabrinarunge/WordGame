package controllers;

import models.Words;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController extends Controller
{
    private FormFactory formFactory;

    @Inject
    public GameController(FormFactory formFactory)
    {
        this.formFactory = formFactory;
    }

    public Result getStart()
    {
        return ok(views.html.start.render());
    }

    public Result getFirstStory()
    {
        Words words = new Words();
        words.setPlace1("Parking Lot");
        words.setAdjective1("fuzzy");
        words.setNoun1("book");
        words.setNoun2("sandwich");
        words.setVerbPastTense("pushed");
        words.setPlace2("hair salon");

        return ok(views.html.story.render(words));
    }

    public Result getSecondStory()
    {
        Words words = new Words();
        words.setPlace1("Runway Show");
        words.setAdjective1("dreamy");
        words.setNoun1("puppy");
        words.setNoun2("avocado");
        words.setVerbPastTense("angered");
        words.setPlace2("DMV");

        return ok(views.html.story.render(words));
    }

    public Result getThirdStory()
    {
        Words words = new Words();
        words.setPlace1("Parks & Rec Department");
        words.setAdjective1("funny");
        words.setNoun1("waffle");
        words.setNoun2("whipped cream");
        words.setVerbPastTense("helped");
        words.setPlace2("Paunch Burger");

        return ok(views.html.story.render(words));
    }

    public Result getRandomStory()
    {
        Random random = new Random();

        List<String> places = new ArrayList<>();
        places.add("JJ's Diner");
        places.add("City Hall");
        places.add("Food 'N Stuff");
        places.add("Ramsett Park");
        places.add("Sweetums Corporation");
        places.add("Snakehole Lounge");
        places.add("Ann's House");
        places.add("Beachview Terrace");
        places.add("Sue's Salads");
        places.add("Very Good Building Company");

        int randomPlaceIndex = random.nextInt(places.size());
        String place1 = places.get(randomPlaceIndex);

        randomPlaceIndex = random.nextInt(places.size());
        String place2 = places.get(randomPlaceIndex);

        List<String> adjectives = new ArrayList<>();
        adjectives.add("legal");
        adjectives.add("additional");
        adjectives.add("used");
        adjectives.add("serious");
        adjectives.add("significant");
        adjectives.add("historical");
        adjectives.add("available");
        adjectives.add("willing");
        adjectives.add("important");
        adjectives.add("terrible");

        int randomAdjectiveIndex = random.nextInt(adjectives.size());
        String adjective1 = adjectives.get(randomAdjectiveIndex);

        List<String> nouns = new ArrayList<>();
        nouns.add("photo");
        nouns.add("coffee");
        nouns.add("lake");
        nouns.add("insect");
        nouns.add("physics");
        nouns.add("insurance");
        nouns.add("collection");
        nouns.add("buyer");
        nouns.add("engine");
        nouns.add("suggestion");

        int randomNounIndex = random.nextInt(nouns.size());
        String noun1 = nouns.get(randomNounIndex);

        randomNounIndex = random.nextInt(nouns.size());
        String noun2 = nouns.get(randomNounIndex);

        List<String> verbs = new ArrayList<>();
        verbs.add("progressed");
        verbs.add("suspected");
        verbs.add("replied");
        verbs.add("hurried");
        verbs.add("weakened");
        verbs.add("diverted");
        verbs.add("treated");
        verbs.add("blamed");
        verbs.add("diminished");
        verbs.add("coincided");

        int randomVerbIndex = random.nextInt(verbs.size());
        String verb1 = verbs.get(randomVerbIndex);

        Words words = new Words();
        words.setPlace1(place1);
        words.setAdjective1(adjective1);
        words.setNoun1(noun1);
        words.setNoun2(noun2);
        words.setVerbPastTense(verb1);
        words.setPlace2(place2);
        return ok(views.html.story.render(words));
    }

    public Result getMyOwnStory()
    {
        return ok(views.html.selectwords.render());
    }

    public Result postMyOwnStory()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String place1 = form.get("place1");
        String adjective1 = form.get("adjective1");
        String noun1 = form.get("noun1");
        String noun2 = form.get("noun2");
        String verb1 = form.get("verb1");
        String place2 = form.get("place2");

        Words words = new Words();
        words.setPlace1(place1);
        words.setAdjective1(adjective1);
        words.setNoun1(noun1);
        words.setNoun2(noun2);
        words.setVerbPastTense(verb1);
        words.setPlace2(place2);

        return ok(views.html.story.render(words));
    }
}
