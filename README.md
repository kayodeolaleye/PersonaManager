 		===============================================================================
                        ATOS IT CHALLENGE APPLICATION
			Team name: AIMS SENEGAL
			Application Name: PersonaManager
			Team members: Kayode Olaleye & Oumar Ba
			Coach: Jean-Marc Cadudal
			Submission date: 25th April 2016
                 ===============================================================================


OVERVIEW
===========
PersonaManager is a native android application that makes it possible for its users to track, revoke access to, filter personal data online. 
This app is submitted to the ATOS IT Challenge 2015 themed: The Right to be Forgotten

PersonaManager does not require user to create an account to use the application. User's information is not stored by the application

The app does the following:

1. Retrieves/displays user personal data on Social networks (Facebook, Twitter, LinkedIn, Google)
2. User can edit and/or restrict access to personal information
3. User can see third-party applications that can access personal information through Facebook, Google, LinkedIn and Twitter.
4. User can revoke the third-party applications access to personal data.
5. Crawls specific blogs/web pages that might contain user personal information and displays the headline of such contents as well as an absolute URL of the web page
6. User can access Google and Bing Right To Be Forgotten forms to submit a request to have a link remove from search index.

TECHNOLOGY
=======================

*Android Studio Framework

REQUIREMENTS FOR INSTALLING app-debug.apk
============================================

1. Minimum SDK: API 21 - Android 5.0 (Lollipop)
2. The application will request permission to access your internet connection.

INSTALLATION GUIDELINES
================================

To install the application on an android device (Try to avoid tablets as we did not check to see if it renders well on tablets)
1. To install the application, download the android app apk file to an android Lollipop 5.0 or later 
2. Click on the downloaded file to install the application.

To install the application on an emulator:
On Android Virtual Device (Galaxy Nexus - AP1 21, Nexus 5 - API 21)
Drag the application to the emulator environment.

TESTING THE APPLICATION
=============================

To help users track their personal information on social networks and find out which third party website has gained access to their personal information through the social networks, users will need to login to the particular social network.

We have created some accounts for testing this functionalities

Following is a list of social networks and the corresponding test-user accounts created to test the application:

GOOGLE:
Email : claudepierre550@gmail.com
password: personamanager

TWITTER:
Email : claudepierre550@gmail.com
password: personamanager

LINKEDIN:
Email : claudepierre550@gmail.com
password: personamanager

FACEBOOK:
Email : claudepierre550@gmail.com
password: personamanager

USE THE APPLICATION TO TRACK PERSONAL INFORMATION ON SOCIAL NETWORK
==========================================================================
The Home Screen contains three tabs: 

1. SOCIAL NETWORK DATA: This page is visible by default. It displays some of the social networks in a gridview. The user can click on  any of the social network to start a new activity which containing a login page of the particular social network. After successful login, users can see personal data on such platform

2. THIRD PARTY WEBSITE: Lists the third-party applications that have access to your personal data through any of the social networks.

3. DATA CRAWLER: Crawls the contents of specific webpages/blogs. (The goal is to crawl these contents, extract user's personal data from these contents based on some keywords previously supplied by the user, then returns a clean result containing only the information about the user.

4. WEB CRAWLER: Accepts URL from user and crawls the URL.

USE THE APPLICATION TO SEND A REQUEST TO GOOGLE, BING FOR PERSONAL DATA REMOVAL
==================================================================================

The Navigation Drawer contains Google and Bing forms for submitting a request for url removal from search indices.  User can fill the form directly from the application environment and submit.

USE THE APPLICATION TO CRAWL WEB PAGES
==================================================
The user can type a URL in the and the URL will be crawled and the result will be displayed on the screen.
This feature is only working for a URL for now. 

URL TO CRAWL: http://www.hollywoodrag.com/category/surgery/


