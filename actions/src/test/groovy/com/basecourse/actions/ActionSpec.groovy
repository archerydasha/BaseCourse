package com.basecourse.actions

import com.basecourse.services.FakeService
import com.basecourse.services.FeedManagement
import com.basecourse.services.FeedService
import com.google.inject.Injector
import com.google.inject.Key
import com.google.inject.TypeLiteral
import spock.lang.Specification

/**
 * Created by dshcherbyna on 13.03.14.
 */
class ActionSpec extends Specification {

     def "createFeed should be called 6 times with correct parameters"() {
        setup:
        def service = Mock(FeedService);
        def Properties properties = new Properties(EventType.FEED_EVENT, "FIM_FIM-FR_0877_76833-1_57_20140527_20140120070615_20140311.zip");
        def FeedNotificatonAction action = new FeedNotificatonAction(service);

        when: action.processEvent(properties);
        then:
        1 * service.createFeed('fim_0877_76833-1_20140527_fac.xml', '16ccd83edd3a12ed29906d1affddff49f8d20d6f')
        1 * service.createFeed('fim_0877_76833-1_20140527_cpy.xml', '55d9be2c73c3db7a4bcbd3bbb207bd99e77aa53e')
        1 * service.createFeed('fim_0877_76833-1_20140527_ins.xml', '82977158e420f588fe744de772fc4f0dbcd978af')
        1 * service.createFeed('fim_0877_76833-1_20140527_col.xml', '07dd76711e40e7270e70c525ce42e085bec094a1')
        1 * service.createFeed('fim_0877_76833-1_20140527_dbp.xml', 'cfb527d694b5862b989003ee72058c4f73dc5210')
        1 * service.createFeed('fim_0877_76833-1_20140527_con.xml', '2653066039cd99ecfde0761da6aae6446ee2bfc3')
    }
}
