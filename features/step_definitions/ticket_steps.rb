# -*- coding: utf-8 -*-
#
# Ticket steps.
#
Given /^I have created a ticket$/ do
  pending # express the regexp above with the code you wish you had
end

When /^I create a ticket "([^"]+)" with reference "([^"]+)"$/ do |name, reference|
  visit 'http://localhost:8080/humphries/ticket/list'
  click_link 'New Ticket'
  fill_in 'name', :with => name
  fill_in 'reference', :with => reference
  fill_in 'description', :with => 'Lorém Ipsûm dœlor s€€t am¥t'
  click_button 'Create'
end

When /^I (add|remove) a "([^"]*)" tag (to|from) ticket "([^"]*)"$/ do |action, tag, ignore, code|
  pending # express the regexp above with the code you wish you had
end

When /^I assign the ticket to "([^"]*)"$/ do |arg1|
  pending # express the regexp above with the code you wish you had
end

Then /^"([^"]+)" should be in the ticket list$/ do |ticket|
  visit 'http://localhost:8080/humphries/ticket/list'
  response.should contain(ticket)
end

Then /^the ticket should have (no|the) "([^"]*)" tag$/ do |action, tag|
  pending # express the regexp above with the code you wish you had
end
