package com.uid.project.sportify.models

import com.huawei.hms.maps.model.LatLng
import com.uid.project.sportify.R
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt

class Registry private constructor() {

    companion object {
        private var user1: User? = null

        var user1Manager: User
            get() {
                if (user1 == null) {
                    user1 = User(
                            "Ana Maria", "ana.maria@yahoo.com",
                            "password", "Grigorescu", java.util.Date.from(
                            LocalDate.parse("1997-11-06").atStartOfDay()
                                    .atZone(ZoneId.systemDefault())
                                    .toInstant()
                    ),
                            mutableListOf(
                                    Sport(
                                            "Aerobics",
                                            Level.BEGINNER,
                                            notSelectedImage = R.drawable.aerobics,
                                            selectedImage = R.drawable.aerobics_selected
                                    ),
                                    Sport(
                                            "Basketball",
                                            Level.EXPERT,
                                            notSelectedImage = R.drawable.basketball,
                                            selectedImage = R.drawable.backetball_selected
                                    ),
                            ),
                            mutableListOf("#ParculMare", "#ProfessionalTenis", "#Politehnica"),
                            mutableListOf(
                                    Participation(
                                            Activity(
                                                    "Basketball Match",
                                                    "Gheorgheni",
                                                    Date(Date().time - 2 * (1000 * 60 * 60 * 24)),
                                                    R.drawable.basketball_presentation
                                            ), PaticipationType.PLAYER
                                    ),
                                    Participation(
                                            Activity(
                                                    "Tennis Match",
                                                    "Grigorescu",
                                                    Date(Date().time + (1000 * 60 * 60 * 24 + 1000 * 60 * 300)),
                                                    R.drawable.tennis_presentation
                                            ), PaticipationType.VIEWER
                                    ),
                                    Participation(
                                            Activity(
                                                    "Tennis Match",
                                                    "Manastur",
                                                    Date(Date().time - (1000 * 60 * 60 * 24 + 1000 * 60 * 6543)),
                                                    R.drawable.tennis_presentation
                                            ), PaticipationType.VIEWER
                                    ),
                                    Participation(
                                            Activity(
                                                    "Basketball Match",
                                                    "Zorilor",
                                                    Date(Date().time + 3 * (1000 * 60 * 60 * 12)),
                                                    R.drawable.basketball_presentation
                                            ), PaticipationType.PLAYER
                                    ),
                                    Participation(
                                            Activity(
                                                    "Aerobics Class",
                                                    "Grigorescu",
                                                    Date(Date().time - 4 * (1000 * 60 * 60 * 12)),
                                                    R.drawable.aerobics_presentation
                                            ), PaticipationType.PLAYER
                                    )

                            ),
                            R.drawable.ana_profile_picture
                    )
                }

                return user1 as User
            }
            set(u: User) {
                user1 = u
            }
        private var place1: PlaceResult? = null
        var place1Manager: PlaceResult
            get() {

                if (place1 == null) {
                    place1 = PlaceResult(
                            "Yoga Venue Central",
                            R.drawable.yogaplace,
                            // "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Ftheyogaplaceskopje%2Fphotos%2F&psig=AOvVaw1STjfrcu0MkG6J2RxZNuw3&ust=1608816607772000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIC--4Wb5O0CFQAAAAAdAAAAABAD",
                            "Perfect spot for yoga events just in the center of Cluj.",
                            "Centru",
                            "3.3",
                            "100",
                            listOf<String>("2021-09-09", "2021-01-01"),
                            10,
                            "Yoga"
                            //  "Yoga"

                    )
                }
                return place1 as PlaceResult

            }
            set(u: PlaceResult) {
                place1 = u
            }

        private var event1: Event? = null
        var event1Manager: Event
            get() {
                if (event1 == null) {
                    event1 = Event(
                            "", R.drawable.event_picture, "", "",
                            LocalDate.MIN, LocalTime.MIN, LocalTime.MAX, 0, 0,
                            Location("", "Centru", Coordinates(46.766667, 23.583333)),
                            arrayListOf(), ArrayList(), ArrayList()
                    )
                }
                return event1 as Event
            }
            set(e: Event) {
                event1 = e
            }

        private var event2: Event? = null
        var event2Manager: Event
            get() {
                if (event2 == null) {
                    event2 = Event(
                            "Volleyball game for beginners",
                            R.drawable.event_picture,
                            "Alex Ion",
                            "This event targets all amateur volleyball players or even those inexperienced! Cantec, joc, si voie buna la noi!",
                            LocalDate.parse("05/01/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalTime.parse("12:00", DateTimeFormatter.ofPattern("HH:mm")),
                            LocalTime.parse("14:30", DateTimeFormatter.ofPattern("HH:mm")),
                            12,
                            10,
                            Location("Sala sporturilor", "Centru", Coordinates(46.766667, 23.583333)),
                            arrayListOf(Sport("Volleyball", Level.BEGINNER)),
                            arrayListOf("appropriate sport shoes"),
                            arrayListOf("Volleyball", "beginner")
                    )
                }
                return event2 as Event
            }
            set(e: Event) {
                event2 = e
            }

        private var event3: Event? = null
        var event3Manager: Event
            get() {
                if (event3 == null) {
                    event3 = Event(
                            "Monthly school football competition",
                            R.drawable.sport_pic_2,
                            "Maria Pop",
                            "We welcome all schools from Cluj-Napoca to participate to this football and basketball event!",
                            LocalDate.parse("12/02/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            LocalTime.parse("10:00", DateTimeFormatter.ofPattern("HH:mm")),
                            LocalTime.parse("15:00", DateTimeFormatter.ofPattern("HH:mm")),
                            20,
                            0,
                            Location("", "Centru", Coordinates(46.766667, 23.583333)),
                            ArrayList(), ArrayList(), ArrayList()
                    )
                }
                return event3 as Event
            }
            set(e: Event) {
                event3 = e
            }

        val setOfTags: MutableSet<String>
            get() = mutableSetOf(
                    "#Rozelor",
                    "#ParculMare",
                    "#Politehnica",
                    "#Babes",
                    "#ProfessionalBasketball",
                    "#ChildFriendly"
            )

        val setOfAvailableSports: Set<Sport>
            get() = setOf(
                    Sport(
                            "Aerobics",
                            Level.FAN,
                            notSelectedImage = R.drawable.aerobics,
                            selectedImage = R.drawable.aerobics_selected
                    ),
                    Sport(
                            "Basketball",
                            Level.FAN,
                            notSelectedImage = R.drawable.basketball,
                            selectedImage = R.drawable.backetball_selected
                    ),
                    Sport(
                            "Combat",
                            Level.FAN,
                            notSelectedImage = R.drawable.combat,
                            selectedImage = R.drawable.combat_selected
                    ),
                    Sport(
                            "Dance",
                            Level.FAN,
                            notSelectedImage = R.drawable.dance,
                            selectedImage = R.drawable.dance_selected
                    ),
                    Sport(
                            "Football",
                            Level.FAN,
                            notSelectedImage = R.drawable.football,
                            selectedImage = R.drawable.football_selected
                    ),
                    Sport(
                            "Handball",
                            Level.FAN,
                            notSelectedImage = R.drawable.handball,
                            selectedImage = R.drawable.handball_selected
                    ),
                    Sport(
                            "Karate",
                            Level.FAN,
                            notSelectedImage = R.drawable.karate,
                            selectedImage = R.drawable.karate_selected
                    ),
                    Sport(
                            "Pilates",
                            Level.FAN,
                            notSelectedImage = R.drawable.pilates,
                            selectedImage = R.drawable.pilates_selected
                    ),
                    Sport(
                            "Running",
                            Level.FAN,
                            notSelectedImage = R.drawable.running,
                            selectedImage = R.drawable.running_selected
                    ),
                    Sport(
                            "Cycling",
                            Level.FAN,
                            notSelectedImage = R.drawable.spinning,
                            selectedImage = R.drawable.biking_selected
                    ),
                    Sport(
                            "Swimming",
                            Level.FAN,
                            notSelectedImage = R.drawable.swimming,
                            selectedImage = R.drawable.swimming_selected
                    ),
                    Sport(
                            "Tennis",
                            Level.FAN,
                            notSelectedImage = R.drawable.tennis,
                            selectedImage = R.drawable.tennis_selected
                    ),
                    Sport(
                            "Volleyball",
                            Level.FAN,
                            notSelectedImage = R.drawable.volleyball,
                            selectedImage = R.drawable.volleyball_selected
                    ),
                    Sport(
                            "Walking",
                            Level.FAN,
                            notSelectedImage = R.drawable.walking,
                            selectedImage = R.drawable.walking_selected
                    ),
                    Sport(
                            "Yoga",
                            Level.FAN,
                            notSelectedImage = R.drawable.yoga,
                            selectedImage = R.drawable.yoga_selected
                    ),
            )

        val listOfFriends: MutableList<Friend>
            get() = mutableListOf(
                    Friend("Carina", R.drawable.friend1),
                    Friend("Bianca", R.drawable.friend3),
                    Friend("Stefan", R.drawable.friend2),
                    Friend("Ioana", R.drawable.friend4),
                    Friend("Alex", R.drawable.friend5),
                    Friend("George", R.drawable.friend6)
            )

        val listOfNeighborhoods: List<Neighborhood>
            get() = listOf(
                    Neighborhood("Grigorescu", mutableListOf(
                            LatLng(46.7613847, 23.5447311),
                            LatLng(46.7615023, 23.5464907),
                            LatLng(46.7655298, 23.5513830),
                            LatLng(46.7657943, 23.5546875),
                            LatLng(46.7680284, 23.5593653),
                            LatLng(46.7676169, 23.5663176),
                            LatLng(46.7697627, 23.5712528),
                            LatLng(46.7722317, 23.5817671),
                            LatLng(46.7740246, 23.5613823),
                            LatLng(46.7709972, 23.5504818),
                            LatLng(46.7650006, 23.5418558),
                            LatLng(46.7650300, 23.5448170),
                            LatLng(46.7613847, 23.5447311))),
                    Neighborhood("Centru", mutableListOf(
                            LatLng(46.7740834, 23.5876465),
                            LatLng(46.7697627, 23.5745144),
                            LatLng(46.7677932, 23.5736561),
                            LatLng(46.7670584, 23.5743856),
                            LatLng(46.7675287, 23.5774755),
                            LatLng(46.7659707, 23.5786772),
                            LatLng(46.7637659, 23.5842562),
                            LatLng(46.7660295, 23.5859728),
                            LatLng(46.7663529, 23.5927963),
                            LatLng(46.7672347, 23.5968304),
                            LatLng(46.7674111, 23.6000061),
                            LatLng(46.7715851, 23.6085463),
                            LatLng(46.7757293, 23.6042118),
                            LatLng(46.7760820, 23.5942984),
                            LatLng(46.7740246, 23.5875607),
                            LatLng(46.7740834, 23.5876465))),
                    Neighborhood("Manastur", mutableListOf(
                            LatLng(46.7634132, 23.549495),
                            LatLng(46.7619727, 23.547821),
                            LatLng(46.7609731, 23.5425446),
                            LatLng(46.7503591, 23.5443483),
                            LatLng(46.7481243, 23.5548272),
                            LatLng(46.7433309, 23.5585206),
                            LatLng(46.7498886, 23.5670239),
                            LatLng(46.7523292, 23.5736376),
                            LatLng(46.7567101, 23.5721345),
                            LatLng(46.7606497, 23.5660319),
                            LatLng(46.7602088, 23.5568414),
                            LatLng(46.7643245, 23.5513014),
                            LatLng(46.7639717, 23.5486859))),
                    Neighborhood("Gheorgheni", mutableListOf(
                            LatLng(46.7777279, 23.6196324),
                            LatLng(46.7758469, 23.6118162),
                            LatLng(46.770086, 23.6065354),
                            LatLng(46.7676169, 23.6001989),
                            LatLng(46.7569747, 23.6194818),
                            LatLng(46.7618551, 23.6216291),
                            LatLng(46.7630898, 23.6260549),
                            LatLng(46.7636778, 23.6325804),
                            LatLng(46.7736426, 23.6349854),
                            LatLng(46.772849, 23.6227887),
                            LatLng(46.7777279, 23.6196324))),
                    Neighborhood("Zorilor", mutableListOf(
                            LatLng(46.7561809, 23.5724163),
                            LatLng(46.7495946, 23.5768827),
                            LatLng(46.7512412, 23.583024),
                            LatLng(46.7482125, 23.5851284),
                            LatLng(46.7477126, 23.5932452),
                            LatLng(46.7560633, 23.5972392),
                            LatLng(46.7594738, 23.5919139),
                            LatLng(46.7575333, 23.5812632),
                            LatLng(46.7576804, 23.5752937),
                            LatLng(46.7561809, 23.5724163))),
                    Neighborhood("Marasti", mutableListOf(
                            LatLng(46.7859564, 23.5971155),
                            LatLng(46.7837818, 23.6367119),
                            LatLng(46.7822537, 23.6403194),
                            LatLng(46.7789622, 23.6194475),
                            LatLng(46.777434, 23.6202206),
                            LatLng(46.7735544, 23.6061922),
                            LatLng(46.7767286, 23.6027547),
                            LatLng(46.7793149, 23.5937658),
                            LatLng(46.7859564, 23.5971155)
                    )
                    ),
            )

        val listOfEvents: ArrayList<Event?>
            get() = arrayListOf(event1, event2, event3)

        val listofNewsFeedPosts: ArrayList<NewsFeedPost>
            get() = arrayListOf(
                    NewsFeedPostEvent(R.drawable.boy_pic_3, Registry.event2Manager),
                    NewsFeedPostPhotos(
                            R.drawable.girl_pic_2,
                            "1 hour ago",
                            "The boys from Colegiul National Vasile Lucaciu won the cup" +
                                    "once again this month! Congrats to everyone!!",
                            R.drawable.sport_pic_1,
                            event3Manager
                    )
            )

        val listOfRandomMessages: ArrayList<String>
            get() = arrayListOf(
                    "Can't wait!", "Ok!", "Cool!", "See you there!", "Have a nice day!", "Good evening!",
                    "TTY later!", "Bye byee", "That's right, I cannot miss this", "I'll be waiting for u!"
            )


        val listOfMessages: ArrayList<Message>
            get() = arrayListOf(
                    Message("Hello, Ana!", MessageType.MSG_RECEIVED),
                    Message("I haven't heard from u in a while", MessageType.MSG_RECEIVED),
                    Message("Hello dear friend!", MessageType.MSG_SENT),
                    Message("Yeah I know...", MessageType.MSG_SENT),
                    Message("Been busy with the final exams", MessageType.MSG_SENT),
                    Message("But now I'm free as a bird!", MessageType.MSG_SENT),
                    Message("That's great news!", MessageType.MSG_RECEIVED),
                    Message("How are u?", MessageType.MSG_RECEIVED),
                    Message(
                            "Super fine! Gettin ready for the monthly student volleyball game!",
                            MessageType.MSG_SENT
                    ),
                    Message("Are u coming too?", MessageType.MSG_SENT),
                    Message("Yes, just arrived at the place", MessageType.MSG_RECEIVED),
                    Message("Great! See u there then!", MessageType.MSG_SENT),
                    Message(listOfRandomMessages[nextInt(0, 9)], MessageType.MSG_RECEIVED)
            )

        val listOfChatMessages: ArrayList<ChatMessage>
            get() = arrayListOf(
                    ChatMessage(
                            Friend("Dina Meyer", R.drawable.girl_pic_1),
                            "2 hrs",
                            "",
                            false,
                            listOfMessages
                    ),
                    ChatMessage(
                            Friend("Stephane Moreau", R.drawable.boy_pic_1),
                            "3 hrs",
                            "",
                            false,
                            listOfMessages
                    ),
                    ChatMessage(
                            Friend("Andrew James", R.drawable.boy_pic_2),
                            "9 hrs",
                            "",
                            true,
                            listOfMessages
                    ),
                    ChatMessage(
                            Friend("Andreea Pop", R.drawable.girl_pic_2),
                            "Aug 19",
                            "",
                            true,
                            listOfMessages
                    ),
                    ChatMessage(
                            Friend("John Smith", R.drawable.boy_pic_3),
                            "Jul 24",
                            "",
                            true,
                            listOfMessages
                    ),
                    ChatMessage(
                            Friend("Jane Doe", R.drawable.girl_pic_3),
                            "Jun 12",
                            "",
                            true,
                            listOfMessages
                    )
            )

        val listOfLocations: ArrayList<Location>
            get() = arrayListOf(Location("Sala Sporturilor", "Manastur", Coordinates(46.76564585071395, 23.564550507738485)),
                    Location("Complex Sportiv Gheorgheni", "Gheorgheni", Coordinates(46.76849513345118, 23.63299188574465)),
                    Location("Bazinul Olimpic UTCN", "Manastur", Coordinates(46.76604429284985, 23.564366284392985)),
                    Location("Bazin Olimpic Grigorescu", "Grigorescu", Coordinates(46.7643645231033, 23.54537124323578)),
                    Location("Sala Sport CNER", "Centru", Coordinates(46.76816046323552, 23.59388245841115)),
                    Location("Teren Tenis Camin UTCN", "Zorilor", Coordinates(46.755703425581494, 23.588802265143215))
            )

        val listOfGroups: MutableList<Group>
            = mutableListOf(Group("'U' Basketball Fanclub", "The official Universitatea Cluj Baskteball Fanclub", "Centru", arrayListOf(), R.drawable.academia_ubt),
                    Group("TennisClub Grigorescu", "Made for tennis lovers in Grigorescu", "Grigorescu", arrayListOf()))

        val listOfOrganizedEvents: ArrayList<Event> =
            arrayListOf(
                Event(
                    "Yoga for beginners",
                    R.drawable.aerobics_presentation,
                    "Maria James ",
                    "We welcome all yoga beginners or even those with no experience to participate to this unique event! The surprise instructor will be announced soon!",
                    LocalDate.parse("20/02/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    LocalTime.parse("16:00", DateTimeFormatter.ofPattern("HH:mm")),
                    LocalTime.parse("18:30", DateTimeFormatter.ofPattern("HH:mm")),
                    20,
                    30,
                    Registry.listOfLocations[3],
                    arrayListOf(Sport("Yoga", Level.BEGINNER)),
                    arrayListOf("appropriate shoes"),
                    arrayListOf("#Yoga", "#beginner")
                )
            )

        val listOfEventPhotos: ArrayList<Int>
            get() = arrayListOf(
                    R.drawable.sport_pic_1,
                    R.drawable.sport_pic_2,
                    R.drawable.sport_pic_3)
        val listOfUsers: ArrayList<User>
            get() = arrayListOf(User(
                    "Alex Augustin", "alex.augustin@gmail.com",
                    "password", "Centru", java.util.Date.from(
                    LocalDate.parse("1999-09-16").atStartOfDay()
                            .atZone(ZoneId.systemDefault())
                            .toInstant()
            ),
                    mutableListOf(
                            Sport(
                                    "Tennis",
                                    Level.ADVANCED,
                                    notSelectedImage = R.drawable.tennis,
                                    selectedImage = R.drawable.tennis_selected
                            )
                    ),
                    mutableListOf("#Rozelor", "#ExpertTenis", "#UBB"),
                    mutableListOf(
                            Participation(
                                    Activity(
                                            "Basketball Match",
                                            "Gheorgheni",
                                            Date(Date().time - 2 * (1000 * 60 * 60 * 24)),
                                            R.drawable.basketball_presentation
                                    ), PaticipationType.PLAYER
                            ),
                            Participation(
                                    Activity(
                                            "Tennis Match",
                                            "Grigorescu",
                                            Date(Date().time + (1000 * 60 * 60 * 24 + 1000 * 60 * 300)),
                                            R.drawable.tennis_presentation
                                    ), PaticipationType.VIEWER
                            ),
                            Participation(
                                    Activity(
                                            "Tennis Match",
                                            "Manastur",
                                            Date(Date().time - (1000 * 60 * 60 * 24 + 1000 * 60 * 6543)),
                                            R.drawable.tennis_presentation
                                    ), PaticipationType.VIEWER
                            ),
                            Participation(
                                    Activity(
                                            "Basketball Match",
                                            "Zorilor",
                                            Date(Date().time + 3 * (1000 * 60 * 60 * 12)),
                                            R.drawable.basketball_presentation
                                    ), PaticipationType.PLAYER
                            ),
                            Participation(
                                    Activity(
                                            "Aerobics Class",
                                            "Grigorescu",
                                            Date(Date().time - 4 * (1000 * 60 * 60 * 12)),
                                            R.drawable.aerobics_presentation
                                    ), PaticipationType.PLAYER
                            )

                    ),
                    R.drawable.friend6
            ), user1Manager)


        val listOfPlaceResults: ArrayList<PlaceResult>
            get() = arrayListOf(place1Manager,PlaceResult(
                    "Gheorgheni Basketball Court",
                    R.drawable.basketballplace,
                    // "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Ftheyogaplaceskopje%2Fphotos%2F&psig=AOvVaw1STjfrcu0MkG6J2RxZNuw3&ust=1608816607772000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIC--4Wb5O0CFQAAAAAdAAAAABAD",
                    "Amazing Basketball Court in Gheorgheni.",
                    "Gheorgheni",
                    "5",
                    "300",
                    listOf<String>("2021-10-10", "2021-11-11"),
                    30,
                    "Basketball"//dates when the place is occupied
                    //  "Yoga"

            ),
                    PlaceResult(
                            "Central Fitness Place",
                            R.drawable.fitnessplace,
                            // "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Ftheyogaplaceskopje%2Fphotos%2F&psig=AOvVaw1STjfrcu0MkG6J2RxZNuw3&ust=1608816607772000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCIC--4Wb5O0CFQAAAAAdAAAAABAD",
                            "Join us in this big fitness place.",
                            "Centru",
                            "2",
                            "500",
                            listOf<String>("2021-12-12", "2021-08-08"),
                            20,
                            "Fitness"//dates when the place is occupied
                            //  "Yoga"

                    ))

    }
}