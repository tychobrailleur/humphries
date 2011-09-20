#
# Ticket steps.
#


When /^I create a ticket "([^"]+)" with reference "([^"]+)"$/ do |name, reference|
  visit 'http://localhost:8080/humphries/ticket/list'
  click_link 'New Ticket'
  fill_in 'name', :with => name
  fill_in 'reference', :with => reference
  fill_in 'description', :with => 'Lorém Ipsûm dœlor s€€t am¥t'
  click_button 'Create'
end

Then /^"([^"]+)" should be in the ticket list$/ do |ticket|
  visit 'http://localhost:8080/humphries/ticket/list'
  response.should contain(ticket)
end
