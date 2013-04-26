<?php
include "bp.class.php";
$street_no = '700';
$street_name = 'Atlantic Avenue';
$loc_result = $inst->getFromStreet($street_no,$street_name);
echo "here";
?>