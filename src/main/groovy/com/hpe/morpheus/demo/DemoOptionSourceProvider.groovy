package com.hpe.morpheus.demo

import com.morpheusdata.core.AbstractOptionSourceProvider
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.Plugin
import groovy.util.logging.Slf4j

@Slf4j
class DemoOptionSourceProvider extends AbstractOptionSourceProvider {


    OptionSourceDemoPlugin plugin
    MorpheusContext morpheusContext

    DemoOptionSourceProvider(OptionSourceDemoPlugin plugin, MorpheusContext context) {
        this.plugin = plugin
        this.morpheusContext = context
    }

    @Override
    List<String> getMethodNames() {
        return new ArrayList<String>(['listCoordinates'])
    }

    @Override
    MorpheusContext getMorpheus() {
        return this.morpheusContext
    }

    @Override
    Plugin getPlugin() {
        return this.plugin
    }

    @Override
    String getCode() {
        return 'coordinates'
    }

    @Override
    String getName() {
        return "Coordinates"
    }

    def listCoordinates(args) {
        return [
                [ value: 1, name: "-118.2437,34.0522" ],
                [ value: 2, name: "-122.4194,37.7749" ],
                [ value: 3, name: "-95.3698,29.7604" ],
                [ value: 4, name: "-96.7970,32.7767" ],
                [ value: 5, name: "-80.1918,25.7617" ],
                [ value: 6, name: "-81.3792,28.5383" ],
                [ value: 7, name: "-74.0060,40.7128" ],
                [ value: 8, name: "-78.8784,42.8864" ],
                [ value: 9, name: "-75.1652,39.9526" ],
                [ value: 10, name: "-79.9959,40.4406" ],
                [ value: 11, name: "-79.3832,43.6532" ],
                [ value: 12, name: "-75.6972,45.4215" ],
                [ value: 13, name: "-73.5673,45.5017" ],
                [ value: 14, name: "-71.2082,46.8139" ],
                [ value: 15, name: "-123.1207,49.2827" ],
                [ value: 16, name: "-123.3656,48.4284" ],
                [ value: 17, name: "-114.0719,51.0447" ],
                [ value: 18, name: "-113.4909,53.5461" ],
                [ value: 19, name: "-97.1384,49.8951" ],
                [ value: 20, name: "151.2093,-33.8688" ],
                [ value: 21, name: "151.7817,-32.9267" ],
                [ value: 22, name: "144.9631,-37.8136" ],
                [ value: 23, name: "144.3580,-38.1499" ],
                [ value: 24, name: "153.0251,-27.4698" ],
                [ value: 25, name: "153.4000,-28.0167" ],
                [ value: 26, name: "115.8575,-31.9505" ],
                [ value: 27, name: "115.7498,-32.0569" ],
                [ value: 28, name: "138.6007,-34.9285" ],
                [ value: 29, name: "140.7759,-37.8310" ]
        ]

    }
}
