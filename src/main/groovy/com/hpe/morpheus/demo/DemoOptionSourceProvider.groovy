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
        return new ArrayList<String>(['listZipCodes'])
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
        return 'zipCodes'
    }

    @Override
    String getName() {
        return "ZipCodes"
    }

    def listZipCodes(args) {
        return [
                //US Downtown Zip Code
                [name: 'Los Angeles',     value: '90012'],
                [name: 'San Francisco',   value: '94102'],
                [name: 'Houston',         value: '77002'],
                [name: 'Dallas',          value: '75201'],
                [name: 'Miami',           value: '33131'],
                [name: 'Orlando',         value: '32801'],
                [name: 'New York City',   value: '10007'],
                [name: 'Buffalo',         value: '14202'],
                [name: 'Philadelphia',    value: '19102'],
                [name: 'Pittsburgh',      value: '15222'],

                // Canada (FSA / first 3 of postal code)
                [name: 'Toronto',         value: 'M5H'],
                [name: 'Ottawa',          value: 'K1P'],
                [name: 'Montreal',        value: 'H2Y'],
                [name: 'Quebec City',     value: 'G1K'],
                [name: 'Vancouver',       value: 'V6B'],
                [name: 'Victoria',        value: 'V8W'],
                [name: 'Calgary',         value: 'T2P'],
                [name: 'Edmonton',        value: 'T5J'],
                [name: 'Winnipeg',        value: 'R3C'],

                // Australia (CBD postcodes)
                [name: 'Sydney',          value: '2000'],
                [name: 'Newcastle',       value: '2300'],
                [name: 'Melbourne',       value: '3000'],
                [name: 'Geelong',         value: '3220'],
                [name: 'Brisbane',        value: '4000'],
                [name: 'Gold Coast',      value: '4217'],
                [name: 'Perth',           value: '6000'],
                [name: 'Fremantle',       value: '6160'],
                [name: 'Adelaide',        value: '5000'],
                [name: 'Mount Gambier',   value: '5290'],
        ]

    }
}
