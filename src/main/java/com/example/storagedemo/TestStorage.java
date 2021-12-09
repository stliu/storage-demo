package com.example.storagedemo;

import com.azure.spring.core.resource.AzureStorageBlobProtocolResolver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class TestStorage implements CommandLineRunner {


    private static final String RESOURCE_SEARCH_PATTERN_PREFIX = "azure-blob://file-uploader/";

    private final AzureStorageBlobProtocolResolver storageResourcePatternResolver;

    public TestStorage(AzureStorageBlobProtocolResolver storageResourcePatternResolver) {
        this.storageResourcePatternResolver = storageResourcePatternResolver;
    }

    @Override
    public void run(String... args) throws Exception {
        Resource[] resources = storageResourcePatternResolver.getResources(RESOURCE_SEARCH_PATTERN_PREFIX + "*");
        Assert.isTrue(resources != null && resources.length == 0, "expected empty");

        System.out.println("success without exception");
    }
}
