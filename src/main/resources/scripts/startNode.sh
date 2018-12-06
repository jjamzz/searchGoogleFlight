#!/bin/bash

java -Dwebdriver.chrome.driver=$PWD/src/main/resources/webdriver/chromedriver -jar $PWD/src/main/resources/jars/selenium-server-standalone-3.13.0.jar -role node -nodeConfig $PWD/src/resources/jsons/nodes.json
