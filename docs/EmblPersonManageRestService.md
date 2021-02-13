# EmblPersonManageRestService

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPerson**](EmblPersonManageRestService.md#createPerson) | **POST** /api/v1/persons | create person
[**deletePerson**](EmblPersonManageRestService.md#deletePerson) | **DELETE** /api/v1/persons/{personId} | delete person by personId
[**fetchAllPersons**](EmblPersonManageRestService.md#fetchAllPersons) | **GET** /api/v1/persons | fetch all the persons
[**fetchPerson**](EmblPersonManageRestService.md#fetchPerson) | **GET** /api/v1/persons/{personId} | fetch person by personId
[**updatePerson**](EmblPersonManageRestService.md#updatePerson) | **PUT** /api/v1/persons/{personId} | update person by personId


        <a name="createPerson"></a>
        # **createPerson**
        > Person createPerson(person)

        create person
        stores person in the database


        ### Parameters

        
            Name | Type | Description  | Notes
            ------------- | ------------- | ------------- | -------------
         **person** | [**Person**](Person.md)| Person | [optional]

        ### Return type

        [**Person**](Person.md)

        ### HTTP request headers

        - **Content-Type**: application/json
        - **Accept**: application/json, application

        <a name="deletePerson"></a>
        # **deletePerson**
        > deletePerson(personId)

        delete person by personId
        delete the person by personId from the database


        ### Parameters

        
            Name | Type | Description  | Notes
            ------------- | ------------- | ------------- | -------------
         **personId** | **Long**|  |

        ### Return type

        null (empty response body)

        ### HTTP request headers

        - **Content-Type**: Not defined
        - **Accept**: application

        <a name="fetchAllPersons"></a>
        # **fetchAllPersons**
        > Persons fetchAllPersons()

        fetch all the persons
        fetch all the persons from the database


        ### Parameters

        This endpoint does not need any parameter.
        
        ### Return type

        [**Persons**](Persons.md)

        ### HTTP request headers

        - **Content-Type**: Not defined
        - **Accept**: application/json, application

        <a name="fetchPerson"></a>
        # **fetchPerson**
        > Person fetchPerson(personId)

        fetch person by personId
        fetch the person by personId from the database


        ### Parameters

        
            Name | Type | Description  | Notes
            ------------- | ------------- | ------------- | -------------
         **personId** | **Long**|  |

        ### Return type

        [**Person**](Person.md)

        ### HTTP request headers

        - **Content-Type**: Not defined
        - **Accept**: application/json, application

        <a name="updatePerson"></a>
        # **updatePerson**
        > updatePerson(personId, person)

        update person by personId
        update the person by personId from the database


        ### Parameters

        
            Name | Type | Description  | Notes
            ------------- | ------------- | ------------- | -------------
         **personId** | **Long**|  |
 **person** | [**Person**](Person.md)| Person | [optional]

        ### Return type

        null (empty response body)

        ### HTTP request headers

        - **Content-Type**: application/json
        - **Accept**: application

