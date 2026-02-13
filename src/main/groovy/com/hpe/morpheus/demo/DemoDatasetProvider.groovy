package com.hpe.morpheus.demo

import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.Plugin
import com.morpheusdata.core.data.DatasetInfo
import com.morpheusdata.core.data.DatasetQuery
import com.morpheusdata.core.providers.AbstractDatasetProvider
import com.morpheusdata.response.ServiceResponse
import io.reactivex.rxjava3.core.Observable
import groovy.util.logging.Slf4j

@Slf4j
class DemoDatasetProvider extends AbstractDatasetProvider<Map, Long> {

    public static final providerName = 'External API Dataset Provider'
    public static final providerNamespace = 'example'
    public static final providerKey = 'externalApiDatasetExample'
    public static final providerDescription = 'A set of data from an external API'

    static apiService

    DemoDatasetProvider(Plugin plugin, MorpheusContext morpheus) {
        this.plugin = plugin
        this.morpheusContext = morpheus
        //this.apiService = new ApiService()
    }


    @Override
    String getKey() {
        return providerKey
    }


    @Override
    DatasetInfo getInfo() {
        new DatasetInfo(
                name: providerName,
                namespace: providerNamespace,
                key: providerKey,
                description: providerDescription
        )
    }

    Class<Map> getItemType() {
        return Map.class
    }

    Observable<Map> list(DatasetQuery query) {
        //Map authConfig = apiService.getAuthConfig(query.parameters)
        ServiceResponse results =  ServiceResponse.success(
                [
                        [ id: 1, name: "-118.2437,34.0522" ],
                        [ id: 2, name: "-122.4194,37.7749" ],
                        [ id: 3, name: "-95.3698,29.7604" ],
                        [ id: 4, name: "-96.7970,32.7767" ],
                        [ id: 5, name: "-80.1918,25.7617" ],
                        [ id: 6, name: "-81.3792,28.5383" ],
                        [ id: 7, name: "-74.0060,40.7128" ],
                        [ id: 8, name: "-78.8784,42.8864" ],
                        [ id: 9, name: "-75.1652,39.9526" ],
                        [ id: 10, name: "-79.9959,40.4406" ],
                        [ id: 11, name: "-79.3832,43.6532" ],
                        [ id: 12, name: "-75.6972,45.4215" ],
                        [ id: 13, name: "-73.5673,45.5017" ],
                        [ id: 14, name: "-71.2082,46.8139" ],
                        [ id: 15, name: "-123.1207,49.2827" ],
                        [ id: 16, name: "-123.3656,48.4284" ],
                        [ id: 17, name: "-114.0719,51.0447" ],
                        [ id: 18, name: "-113.4909,53.5461" ],
                        [ id: 19, name: "-97.1384,49.8951" ],
                        [ id: 20, name: "151.2093,-33.8688" ],
                        [ id: 21, name: "151.7817,-32.9267" ],
                        [ id: 22, name: "144.9631,-37.8136" ],
                        [ id: 23, name: "144.3580,-38.1499" ],
                        [ id: 24, name: "153.0251,-27.4698" ],
                        [ id: 25, name: "153.4000,-28.0167" ],
                        [ id: 26, name: "115.8575,-31.9505" ],
                        [ id: 27, name: "115.7498,-32.0569" ],
                        [ id: 28, name: "138.6007,-34.9285" ],
                        [ id: 29, name: "140.7759,-37.8310" ]
                ]
        )
        if(results.success) {
            return Observable.fromIterable((List<Map>)results.data)
        }

        return Observable.empty()
    }

    Observable<Map> listOptions(DatasetQuery query) {
        return list(query).map { [name: it.name, value: it.id] }
    }

    Map fetchItem(Object value) {
        def rtn = null
        if(value instanceof Long) {
            rtn = item((Long)value)
        } else if(value instanceof CharSequence) {
            def longValue = value.isNumber() ? value.toLong() : null
            if(longValue) {
                rtn = item(longValue)
            }
        }
        return rtn
    }

    Map item(Long value) {
        def rtn = list(new DatasetQuery()).find{ it.id == value }
        return rtn
    }

    String itemName(Map item) {
        return item.name
    }

    Long itemValue(Map item) {
        return (Long)item.id
    }

    @Override
    boolean isPlugin() {
        return true
    }
}