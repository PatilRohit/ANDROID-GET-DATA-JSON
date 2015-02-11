# ANDROID-GET-DATA-JSON
Simple Android Application to fetch json data from PHP api and show it on TextView 

Add rnbros folder from server to wamp/www/ folder and enable the rewrite_module of Apache

then only enter the Server IP Address(Wi-Fi connected IP) into EditText and get data from server to application 

edit index.php file from wamp/www/rnbros/ folder

 $retMsg= array(
                'Status' => '200',
                'Message' => 'Developed by RN Bros'
            );
            
and change message('Developed by RN Bros') and then hit the get data button again 
& you will get new changed Message into Application

Note : Your Mobile device & wamp server pc should be connected in same Wi-Fi network
