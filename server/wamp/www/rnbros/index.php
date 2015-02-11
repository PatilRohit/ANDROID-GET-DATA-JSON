<?php 
/**
 * API to communicate to device
 * @author		Rohit Patil
 * @package		API File
 * @since		2/11/2015
 * @version             1
 */


require 'Slim/Slim.php';
$app = new Slim();   


$app->get("/get/data", "getData");
$app->run();

function getData() {
	  $request = Slim::getInstance()->request();
      $body = $request->getBody();
      $jsonBody = json_decode($body);
	  $retMsg= array(
                'Status' => '200',
                'Message' => 'Developed by RN Bros'
            );
        
        
        $db = null;
        echo json_encode($retMsg);
   }

             

?>