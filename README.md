# renascence_finix Project
--------------------------------------------------------------------------------
This is a project generated from [appfuse](https://github.com/appfuse/appfuse). 
The project object model (pom) is defined in the file pom.xml.

As a normal appfuse project, the following 3 steps are the same as appfuse. 

1. Download and install a MySQL 5.x database from 
   http://dev.mysql.com/downloads/mysql/5.0.html#downloads.

2. Run "mvn jetty:run" and view the application at http://localhost:8080.

3. More information can be found at:  
   <http://appfuse.org/display/APF/AppFuse+QuickStart/>

Actually, the work on this project is to create RESTFUL APIs. See below. 

--------------------------------------------------------------------------------
# Restful API samples:

## API-1: pull product per the specified category

### Request 
<table>
   <tr>
      <td> URI </fd>
      <td> Method </fd>
      <td> Comments </fd>
   </tr>
   <tr>
      <td> /commodity/product </td>
      <td> GET </td>
      <td> Pull the products of one given category </td>
   </tr>
</table>

#### Parameters

<table>
   <tr>
      <td> Parameter </fd>
      <td> Value </fd>
      <td> Required </fd>
      <td> Comments </fd>
   </tr>
   <tr>
      <td> category1 </td>
      <td> string </td>
      <td> YES </td>
      <td> The first category </td>
   </tr>
   <tr>
      <td> category2 </td>
      <td> string </td>
      <td> No </td>
      <td> The second category </td>
   </tr>
   <tr>
      <td> sortby </td>
      <td> string </td>
      <td> No </td>
      <td> The filed for sorting </td>
   </tr>
   <tr>
      <td> desc </td>
      <td> bool </td>
      <td> No </td>
      <td> The sort type </td>
   </tr>
   <tr>
      <td> start </td>
      <td> integer </td>
      <td> No </td>
      <td> The start index of paging </td>
   </tr>
   <tr>
      <td> amount </td>
      <td> integer </td>
      <td> YES </td>
      <td> The amount of one page </td>
   </tr>
</table>

#### Headers

None

#### Body

None

### Response

#### Status line

* 200 OK. Get the categories successfully.
* 400 Bad request. The request is not conform with restrictions.
* 500 Internal Server Error. Server has logic errors. 

#### Body

	{
       'has_more': bool,
       'pus':[
                   {
                       'id': integer,
                       'name': string,
                       'description': string,
                       'price': float,
                       'items': [
                                    {
                                        'id': integer,
                                        'pictures': [string, ...]
                                    },
                                    ...
                                ]
                   },
                   ...
                   
               ]
    }


#### Sample:  
curl <http://localhost:8080/renascence_finix/commodity/product?category_1=200&category_2=2001&sortby=price&desc=false&start=1&amount=5/>


## API-2: list all the categories

### Request 
<table>
   <tr>
      <td> URI </fd>
      <td> Method </fd>
      <td> Comments </fd>
   </tr>
   <tr>
      <td> /commodity/category </td>
      <td> GET </td>
      <td> Pull the categroies of products </td>
   </tr>
</table>

#### Parameters

None

#### Headers

None

#### Body

None

### Response

#### Status line

* 200 OK. Get the categories successfully.
* 400 Bad request. The request is not conform with restrictions.
* 500 Internal Server Error. Server has logic errors. 

#### Return Body
<pre><code>
    [
        {
            'id': integer,
            'name': string,
            'sub_categories': [
                                  {
                                      'id': integer,
                                      'name': string
                                  },
                                  ...
                              ]
        },
        ...
    ]
</code></pre>

#### Sample:  
curl <http://localhost:8080/renascence_finix/commodity/category>

---------------------------------------------------------------------------
# Quick Start

- Step 1. cd /<path_to_renascence_finix>

- Step 2. mvn install

- Step 3. Import the test data
	- mysql -u<user_name> -p -h localhost renascence_finix < Mysql/data_category.sql
	- mysql -u<user_name> -p -h localhost renascence_finix < Mysql/data_product_item.sql
	
- Step 4. mvn jetty:run

- Step 5. Run curl command to try the APIs. 

