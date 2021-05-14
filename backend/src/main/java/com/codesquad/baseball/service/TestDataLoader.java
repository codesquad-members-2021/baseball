package com.codesquad.baseball.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Service
public class TestDataLoader {
    private static final Logger logger = LoggerFactory.getLogger(TestDataLoader.class);
    private static final String LOADING_TEST_DATA_FAILED_ERROR_MESSAGE = "테스트 데이터 파일을 읽는 과정에서 문제가 발생했습니다. 프로그램을 종료합니다";
    private static final String LOADING_TEST_DATA_COMPLETE = "loading oauth config complete!";

    public HashMap<String, List<String>> loadTestData() {
        HashMap<String, List<String>> testData = null;
        try {
            InputStream inputStream = TestDataLoader.class.getResourceAsStream("/testData.json");
            ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            MapType type = typeFactory.constructMapType(HashMap.class, String.class, List.class);
            testData = objectMapper.readValue(inputStream, type);
        } catch (IOException e) {
            logger.error(LOADING_TEST_DATA_FAILED_ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
        logger.info(LOADING_TEST_DATA_COMPLETE);
        return testData;
    }
}
