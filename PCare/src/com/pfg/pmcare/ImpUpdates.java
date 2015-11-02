package com.pfg.pmcare;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;

public class ImpUpdates extends ExpandableListActivity{
	
	private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		// this is not really  necessary as ExpandableListActivity contains an ExpandableList
		//setContentView(R.layout.main);
		
		
		ExpandableListView expandableList = getExpandableListView(); // you can use (ExpandableListView) findViewById(R.id.list)
		
		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);
		

		setGroupParents();
		setChildData();
		
		

		MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);
		
		adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		expandableList.setAdapter(adapter);	
		expandableList.setOnChildClickListener(this);
		expandableList.expandGroup(3);
			
	}

	public void setGroupParents() {
		parentItems.add("Appraisal Timeline");
		parentItems.add("Investment Proof Submission");
		parentItems.add("Investment Declaration");
		parentItems.add("Income Tax Return");
	}

	public void setChildData() {
		
		// Android
		ArrayList<String> child = new ArrayList<String>();
		child.add("\n\nDear colleagues,\n\nMid-Year performance reviews are round the corner and it is important we all gear up for its meaningful completion. Please find attached Midyear appraisal calendar for your reference."+
                   "\n\nWe have scheduled orientation sessions to assist you on the process and system as per below.  We encourage you to participate in the sessions and to ensure that we effectively achieve the defined objectives of the “Perform and Improve” phase within the timeline."+
                   "We also have HR Leaders to help you clarify doubts, if any."+
                   "\n\nEligibility for participating in Mid-Year Appraisal 2015:"+
                   "\nAll employees who have joined on or before 31-Mar-15. "+
                   "\nAll Promotions/Lateral movements taken place in the period Apr 15 – June 15, would be appraised at the former role only."+
                   "\nAll new hires and promotions/lateral movements, post 01-Apr-15, would be appraised for their prorated period in the month of Dec 15."+
                   "\n\n** Enclosed the user manual for your reference."+
                   "\nWe look forward to your support towards making the review process meaningful and effective."+
                   "\n\n Warm regards,"+
                   "\n\nXYZ\n\n");
		
		childItems.add(child);
		
		
		// Core Java
		child = new ArrayList<String>();
		child.add("\n\nDear Employee,"+
				"\n\nThe year end is round the corner, and shortly you will be required to submit your investment proofs for the year 2014-15."+
				"\n\nWe're pleased to inform you that this year as well document submission will be through the upload option on Hewitt site as prescribed below, which is mandatory."+
				"\n\nInvestment Proof Submission Form (IPSF) along with File upload link will be available on the www.hrworkwaysindia.com portal from 18th Dec 2014 and the last date for submission of Investment proofs is 10th January, 2015."+
				"\n\nA detailed presentation on how to navigate and notify your proofs online is attached."+
				"\n\nProcess to update IPSF on HR Workways:"+
				"\n\n•   Go through the attached guidelines for Investment proof submission that has been signed off by your employer."+
				"\n\n•   Please read this document carefully as proofs will be accepted as per the guidelines only,."+
				"\n\n•   Write your employee id & company name on every investment document/ proof, rent receipts, premium receipts, and other proofs and please keep soft and hard copy of the same handy."+
			    "\n\n•   Logon to HRworkways to update the IPSF with investment proof details."+
				"\n\n•   Post confirmation of IPSF on HRWorkways, take a printout of the Bar-coded IPSF along with annexures, and also keep a soft copy of the signed IPSF form ready for upload in a zip file, before you login to HRworkways portal."+
				"\n\n•   Do not use the Print screen / file print option, instead use the print option displayed on the IPSF."+
				"\n\n•   Attach the relevant proofs along with the bar coded IPSF as the covering sheet."+
				"\n\n•   Drop the packet (IPSF and proofs) into the designated drop-box within the cutoff date."+
				"\n\nInvestment proofs submitted after the cutoff date will not be collected for processing, hence please adhere the timelines."+
				"\n\nIf your date of joining in this organization is after 1st April 2014 and would like to declare your previous employment Income, you should also upload the soft copy of Form 12B that gets generated with the IPSF.  (Even if you have already submitted, you are required to re-submit the same along with the relevant proof i.e. copy of Form 16 / tax computation and other investment proofs as per guidelines)"+
				"\n\nIn case of any query, write to infohos@aonhewitt.com or infohos@aon.com clearly mentioning your employee Id in the subject line of the email."+ 
				"\n\nLet us together make this exercise a smooth and timely one, to ensure diligent proof checking and accurate income tax calculations."+
				"\n\nRegards,"+
				"\n\nABC\n\n");		
		childItems.add(child);
		
		// Desktop Java
		child = new ArrayList<String>();
		child.add("\n\nDear Employee,"+
				"\n\nGreetings from Excelity Global,"+
				"\n\nAs we enter the new Financial Year 2015-2016, it's time to submit Investment Declaration. The investment declaration link is open and you are requested to declare your intended investments to enable appropriate tax calculations from April 2015 onwards, the last date for the same is 15th April 2015 midnight."+
				"\n\nProcess:"+
				"\nKindly, log-on to http://www.hrworkwaysindia.com or through leave management system. (Payroll & Benefits Tab) and follow the following path, to declare your investment for FY 2015-2016:"+
				"\n\nMy Transaction> Investment Declaration."+
				"\n\nImportant Note:-"+
				"\n\n1.   The income tax for the FY 2015-2016 will be calculated based on the declared investments on-line & tax will be deducted for effective current month."+     
				"\n\n2.   Your submitted actual investment proofs for year 2014-2015 will not be considered for year 2015-2016. You need to declare your existing or fresh investment again for year 2015-2016."+
				"\n\n3.   Failing to update your investment declarations on or before 15th April 2015, tax will be calculated and deducted from your April 2015 salary, as if no investments are intended for the year.  Hence, please ensure on-time declaration to save your tax."+
				"\n\n4.   Any tax, deducted from salary, will not be refunded and will be claimed from income tax department along with your personal income tax return only."+
				"\n\n5.   Further you can update your investment declaration in the May 15, September 15 & final Investment Proofs will be considered in the January 2016."+
				"\n\nRegards,"+
				"\n\nPQR\n\n");
		
		childItems.add(child);
		
		
		// Enterprise Java
		child = new ArrayList<String>();
		child.add("\n\nHi,"+
				"\n\nThe Central Board of Direct Taxes has notified Income-tax return forms applicable for the financial year (FY) 2014-15 (assessment year 2015-16). The due date for filing the return of income is 31st August, 2015. The key highlights are as follows:"+
				"\n\nIndividuals now can use the simpler return form (ITR-1) even if they have exempt income. Earlier, individuals were not allowed to use this form if they had exempt income exceeding INR 5,000."+ 
				"\n\nAs a measure of relief to individuals/ Hindu Undivided Family (HUF) who do not have income from capital gains, business or profession, foreign assets/ foreign income to be reported, or who have not claimed any relief under any Double Tax Avoidance Agreement (DTAA) India has with other countries, a new simplified return form (Form ITR-2A) has been introduced."+
				"\n\nForms ITR-2 and ITR-2A have been made more taxpayer-friendly – they are a mere 3 pages long. Other information will be captured in schedules that are required to be filled only wherever applicable. Those who are holding shares under ESPP scheme will have to disclose their holding in ITR-2."+
				"\n\nDetails of foreign trips and expenditure thereon no longer need to be furnished."+
				"\n\nIndian Financial Services (IFS) codes, name of the bank, nature of account (saving/ current) account numbers of all bank accounts have to be furnished in the returns, but not bank balances. Details of accounts that have been non-operational for over three years need not be reported."+
				"\n\n A new method to file the tax return electronically has been set up by using electronic verification code (EVC). Taxpayers now have an option to provide their 12 digit unique Aadhar number in their tax return form and then, instead of sending the signed ITR-V (Acknowledgement of electronically filed return) to the Central Processing Centre (CPC) at Bengaluru, they can authenticate their returns by using the EVC."+
				"\n\nThe taxpayers are now required to disclose their passport number (if available)"+
				"\n\n E-filing of Income-tax return is now mandatory in cases where a refund has been claimed. "+
				"\n\nForeign nationals who qualify as ordinarily resident in India and are on business, employment or student visas are not required to report foreign assets acquired by them during those financial years in which they were non-resident of India, provided they are not deriving any income from such assets during the relevant financial year."+
				"\n\nYou may want to refer the attached file to check which Income Tax Return Form is applicable for you."+ 
				"\n\nIf you have any additional questions please feel free to reach to us."+
				"\n\nThanks & Regards"+
				"\n\nTest\n\n");
		
		childItems.add(child);
	}

}